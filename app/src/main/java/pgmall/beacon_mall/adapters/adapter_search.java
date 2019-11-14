package pgmall.beacon_mall.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pgmall.beacon_mall.activites.activity_shopProfile;
import pgmall.beacon_mall.modules.DataModule;
import pgmall.mall_4.R;

/** adapter search   11/11/2019 */

public class adapter_search extends RecyclerView.Adapter<adapter_search.mVH> implements Filterable {
    Context context;
    ArrayList<DataModule> arrayList1;
    ArrayList<DataModule> arrayList2;

    public adapter_search(Context context,ArrayList<DataModule> arrayList1) {
        this.arrayList1 = arrayList1;
        arrayList2 = new ArrayList<>(arrayList1);
        this.context =context;
    }

    @NonNull
    @Override
    public adapter_search.mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_frag_search, parent, false);
        mVH mVH = new mVH(view);
        return mVH;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_search.mVH holder, int position) {
        final DataModule module = arrayList1.get(position);
        holder.textView1.setText(arrayList1.get(position).getName());
        holder.textView2.setText(arrayList1.get(position).getPhone());
        //Glide.with(context).load(arrayList1.get(position).getUri()).into(holder.iv_shopIcon);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context.getApplicationContext(), activity_shopProfile.class);
                intent.putExtra("name" , module.getName()) ;
                intent.putExtra("phone" , module.getPhone()) ;
                intent.putExtra("uri" , module.getUri()) ;
                intent.putExtra("email" , module.getEmail()) ;
                intent.putExtra("website" , module.getWebsite()) ;
                intent.putExtra("describtion" , module.getDescription()) ;
                intent.putExtra("category" , module.getCategory()) ;
                intent.putExtra("map_id" , module.getMap_id()) ;
                intent.putExtra("beacon_id" , module.getBeacon_id()) ;
                intent.putExtra("uri1" , module.getUri1()) ;
                intent.putExtra("uri2" , module.getUri2()) ;
                intent.putExtra("uri3" , module.getUri3()) ;
                intent.putExtra("uri4" , module.getUri4()) ;
                intent.putExtra("uri5" , module.getUri5()) ;
                context.startActivity(intent);
            }
        });
        try {
            Picasso.with(context)
                    .load(module.getUri())
                    //  .placeholder(R.mipmap.ic_launcher)
                    .error(R.drawable.nopic)
                    .fit()
                    .centerCrop()
                    .into(holder.imageView);
        } catch (Exception e) {
        }

    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }


    public class mVH extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1, textView2;
        ConstraintLayout constraintLayout;


        public mVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.fragSearch_iv);
            textView1 = itemView.findViewById(R.id.fragSearch_tv_1);
            textView2 = itemView.findViewById(R.id.fragSearch_tv_2);
            constraintLayout = itemView.findViewById(R.id.layoutMain_item_search);

        }
    }

    @Override
    public Filter getFilter() {
        return example_filter;
    }

    private Filter example_filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<DataModule> filtered_list = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filtered_list.addAll(arrayList2);
            } else {
                String filterPattern =constraint.toString().toLowerCase().trim();
                for(DataModule dataModule :arrayList2){
                    if (dataModule.getName().toLowerCase().contains(filterPattern)){
                        filtered_list.add(dataModule);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values =filtered_list;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrayList1.clear();
            arrayList1.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}
