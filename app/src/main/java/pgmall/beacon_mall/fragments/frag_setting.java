package pgmall.beacon_mall.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pgmall.beacon_mall.activites.activity_aboutMall;
import pgmall.beacon_mall.activites.activity_survey;
import pgmall.mall_4.R;
import pgmall.beacon_mall.activites.activity_aboutUs;

public class frag_setting extends Fragment {
    LinearLayout survey , aboutmall , aboutus;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate( R.layout.frag_setting,container,false );
        survey = view.findViewById(R.id.layout2);

        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), activity_survey.class);
                startActivity(intent);
            }
        });

        aboutmall = view.findViewById(R.id.layout3);

        aboutmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), activity_aboutMall.class);
                startActivity(intent);
            }
        });
        aboutus = view.findViewById(R.id.layout4);

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), activity_aboutUs.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
