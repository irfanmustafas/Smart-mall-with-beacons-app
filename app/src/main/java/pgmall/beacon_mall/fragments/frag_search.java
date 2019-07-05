package pgmall.beacon_mall.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import pgmall.beacon_mall.activites.SearchNEW;
import pgmall.beacon_mall.modules.DataModule;
import pgmall.mall_4.R;

public class frag_search extends Fragment {
    private EditText mSearchField;
    private ImageButton mSearchBtn;

    private RecyclerView mResultList;

    private DatabaseReference mUserDatabase;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_frag, container, false);
        mUserDatabase = FirebaseDatabase.getInstance().getReference("root").child("cinema");
        mSearchField = (EditText) view.findViewById(R.id.search_field);
        mSearchBtn = (ImageButton) view.findViewById(R.id.search_btn);
        mResultList = (RecyclerView) view.findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(getContext()));
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String searchText = mSearchField.getText().toString();

                firebaseUserSearch(searchText);
            }
        });
//        mRecyclerView = view.findViewById( R.id.frag_search_list_view );
//        mRecyclerView.setLayoutManager( new LinearLayoutManager(this.getActivity()) );
//        mRecyclerView.setAdapter( new LinearAdapter(text,images ) );




        return view;
    }

    private void firebaseUserSearch(String searchText) {

        Toast.makeText(getContext(), "Started Search", Toast.LENGTH_LONG).show();

        Query firebaseSearchQuery = mUserDatabase.orderByChild("name").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<DataModule, SearchNEW.UsersViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<DataModule, SearchNEW.UsersViewHolder>(

                DataModule.class,
                R.layout.list_layout,
                SearchNEW.UsersViewHolder.class,
                firebaseSearchQuery

        ) {
            @Override
            protected void populateViewHolder(SearchNEW.UsersViewHolder viewHolder, DataModule dataModule, int position) {


                viewHolder.setDetails(getContext(), dataModule.getName(), dataModule.getPhone(), dataModule.getUri());


            }
        };

        mResultList.setAdapter(firebaseRecyclerAdapter);

    }


    // View Holder Class

    public static class UsersViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public UsersViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setDetails(Context ctx, String userName, String userStatus, String userImage) {

            TextView user_name =  mView.findViewById(R.id.name_text);
           // TextView user_status = mView.findViewById(R.id.status_text);
            ImageView user_image =  mView.findViewById(R.id.profile_image);

            user_name.setText(userName);
          //  user_status.setText(userStatus);

            Glide.with(ctx).load(userImage).into(user_image);


        }
    }
}
