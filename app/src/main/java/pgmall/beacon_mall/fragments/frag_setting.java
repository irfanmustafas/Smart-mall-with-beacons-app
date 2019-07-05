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

import pgmall.beacon_mall.activites.AboutMall;
import pgmall.beacon_mall.activites.Survey_activity;
import pgmall.mall_4.R;
import pgmall.beacon_mall.activites.AboutUs;

public class frag_setting extends Fragment {
    LinearLayout survey , aboutmall , aboutus;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate( R.layout.frag_setting,container,false );
        survey = view.findViewById(R.id.survey_button);

        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Survey_activity.class);
                startActivity(intent);
            }
        });

        aboutmall = view.findViewById(R.id.aboutMall);

        aboutmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AboutMall.class);
                startActivity(intent);
            }
        });
        aboutus = view.findViewById(R.id.aboutMall);

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AboutUs.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
