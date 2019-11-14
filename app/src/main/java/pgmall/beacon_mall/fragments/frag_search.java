package pgmall.beacon_mall.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import pgmall.beacon_mall.adapters.adapter_search;
import pgmall.beacon_mall.modules.DataModule;
import pgmall.mall_4.R;

public class frag_search extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private ArrayList<DataModule> arrayList;
    private pgmall.beacon_mall.adapters.adapter_search adapter_search;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_search, container, false);
        setRecyclerView();
        setSearchView();
        getAllDataBase();
        return view;
    }

    private void setRecyclerView() {
        recyclerView = view.findViewById(R.id.rv_frag_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList = new ArrayList<>();
    }

    private void setSearchView() {
        SearchView searchView = view.findViewById(R.id.search_view_frag_Search);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setQueryHint("search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter_search.getFilter().filter(newText);
                return false;
            }
        });

    }

    private void getDatabase(String choosesPart) {
        DatabaseReference mUserDatabase = FirebaseDatabase.getInstance().getReference("root").child(choosesPart);
        mUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DataModule module = snapshot.getValue(DataModule.class);
                    arrayList.add(module);
                }
                adapter_search = new adapter_search(getContext(), arrayList);
                recyclerView.setAdapter(adapter_search);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getAllDataBase() {
        final String s0, s1, s2, s3, s4, s5;
        s0 = "cinema";
        s1 = "dinning";
        s2 = "entertainment";
        s3 = "fashion";
        s4 = "optics";
        s5 = "sportwear";
        getDatabase(s0);
        getDatabase(s1);
        getDatabase(s2);
        getDatabase(s3);
        getDatabase(s4);
        getDatabase(s5);
    }


}
