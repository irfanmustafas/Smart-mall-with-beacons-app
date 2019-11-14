package pgmall.beacon_mall.activites;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import pgmall.beacon_mall.adapters.adapter_shopsList;
import pgmall.beacon_mall.modules.DataModule;
import pgmall.mall_4.R;

public class activity_shopsList extends AppCompatActivity  {
    RecyclerView recyclerView;
        DatabaseReference reference;
        adapter_shopsList madapter;
        ArrayList<DataModule> dataModuleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopslist);
        recyclerView = findViewById(R.id.rv_activityShopsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity_shopsList.this));
        dataModuleList = new ArrayList<>();
        Intent intent = getIntent();
        String c = intent.getStringExtra("c");
        reference = FirebaseDatabase.getInstance().getReference("root").child(c);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DataModule module = snapshot.getValue(DataModule.class);
                    dataModuleList.add(module);
                }
                madapter = new adapter_shopsList( dataModuleList);
                recyclerView.setAdapter(madapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(activity_shopsList.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}

