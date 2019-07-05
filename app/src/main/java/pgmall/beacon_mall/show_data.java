package pgmall.beacon_mall;

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

import pgmall.beacon_mall.adapters.showdata_adapter;
import pgmall.beacon_mall.modules.DataModule;
import pgmall.mall_4.R;

public class show_data extends AppCompatActivity  {
    RecyclerView recyclerView;
        DatabaseReference reference;
        showdata_adapter madapter;
        ArrayList<DataModule> dataModuleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_data);
        recyclerView = findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(show_data.this));
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
                madapter = new showdata_adapter(show_data.this, dataModuleList);
                recyclerView.setAdapter(madapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(show_data.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}

