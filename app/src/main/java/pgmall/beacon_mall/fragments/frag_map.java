package pgmall.beacon_mall.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.estimote.proximity_sdk.api.ProximityObserver;

import pgmall.beacon_mall.map_view.Map2Viewer;
import pgmall.mall_4.R;

public class frag_map extends Fragment {
    Button map ;
    private ProximityObserver proximityObserver;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_map, container, false);
        map = view.findViewById(R.id.map_button);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Map2Viewer.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
