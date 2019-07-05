package pgmall.beacon_mall.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.estimote.mustard.rx_goodness.rx_requirements_wizard.Requirement;
import com.estimote.mustard.rx_goodness.rx_requirements_wizard.RequirementsWizardFactory;
import com.estimote.proximity_sdk.api.EstimoteCloudCredentials;
import com.estimote.proximity_sdk.api.ProximityObserver;
import com.estimote.proximity_sdk.api.ProximityObserverBuilder;
import com.estimote.proximity_sdk.api.ProximityZone;
import com.estimote.proximity_sdk.api.ProximityZoneBuilder;
import com.estimote.proximity_sdk.api.ProximityZoneContext;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pgmall.beacon_mall.map_view.MapViewer;
import pgmall.beacon_mall.modules.DataModule;
import pgmall.mall_4.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public class frag_beacon extends Fragment {
    Button beacons;
    private ProximityObserver proximityObserver;

    DataModule dataModule = new DataModule();
    String beacon_from_bluetooth = "a";
    String[] all_beacons_id_list;
    DatabaseReference reference;
    ArrayList<DataModule> dataModuleList;
    String[] categ = {"cinema", "dinning", "entertainment", "fashion", "optics", "sportwear"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_beacon, container, false);

        // map = view.findViewById(R.id.map_button);
        beacons = view.findViewById(R.id.beacons_button);
       // int size = dataModule-List.size();
        reference = FirebaseDatabase.getInstance().getReference("root");
        String searchText = "zara";
        final Intent i = new Intent(getActivity(), MapViewer.class);

        dataModuleList = new ArrayList<>();









        beacons.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Beacons_ON();

            }
        });

        return view;
    }

    public void Beacons_ON() {

        EstimoteCloudCredentials cloudCredentials =
                new EstimoteCloudCredentials("mallapp-6sx", "602e0f8ebbcf652e22b4eb701281f0e2");


        // 2. Create the Proximity Observer
        this.proximityObserver =
                new ProximityObserverBuilder(getContext(), cloudCredentials)
                        .onError(new Function1<Throwable, Unit>() {
                            @Override
                            public Unit invoke(Throwable throwable) {
                                Log.e("app", "proximity observer error: " + throwable);
                                return null;
                            }
                        })
                        .withBalancedPowerMode()
                        .build();
        final Intent i = new Intent(getContext(), MapViewer.class);
        final ProximityZone zone = new ProximityZoneBuilder()
                .forTag("Mall")
                .inCustomRange(3.5)
                .onEnter(new Function1<ProximityZoneContext, Unit>() {
                    @Override
                    public Unit invoke(ProximityZoneContext context) {
                        String beacon_id = context.getDeviceId();
                        String b1 = beacon_id ;
                        //     beacons.setText(" " + beacon_id);
                        i.putExtra("Value1", b1);
                        startActivity(i);
                        return null;
                    }
                })
                .onExit(new Function1<ProximityZoneContext, Unit>() {
                    @Override
                    public Unit invoke(ProximityZoneContext context) {
                        return null;
                    }
                })
                .onContextChange(new Function1<Set<? extends ProximityZoneContext>, Unit>() {
                    @Override
                    public Unit invoke(Set<? extends ProximityZoneContext> contexts) {
                        List<String> deskOwners = new ArrayList<>();
                        for (ProximityZoneContext context : contexts) {
                            deskOwners.add(context.getAttachments().get("desk-owner"));
                        }
                        Log.d("app", "In range of desks: " + deskOwners);
                        return null;
                    }
                })
                .build();
        RequirementsWizardFactory
                .createEstimoteRequirementsWizard()
                .fulfillRequirements((Activity) getContext(),
                        // onRequirementsFulfilled
                        new Function0<Unit>() {
                            @Override
                            public Unit invoke() {
                                Log.d("app", "requirements fulfilled");
                                proximityObserver.startObserving(zone);
                                return null;
                            }
                        },
                        // onRequirementsMissing
                        new Function1<List<? extends Requirement>, Unit>() {
                            @Override
                            public Unit invoke(List<? extends Requirement> requirements) {

                                Log.e("app", "requirements missing: " + requirements);
                                return null;
                            }
                        },
                        // onError
                        new Function1<Throwable, Unit>() {
                            @Override
                            public Unit invoke(Throwable throwable) {
                                Log.e("app", "requirements error: " + throwable);
                                return null;
                            }
                        });


    }

    private ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            dataModuleList.clear();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                DataModule module = snapshot.getValue(DataModule.class);
                dataModuleList.add(module);
                Toast.makeText(getActivity(),module.getMap_id(),Toast.LENGTH_LONG).show();

            }

    }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };
}
