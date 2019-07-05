package pgmall.beacon_mall.adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

import pgmall.beacon_mall.modules.DataModule;
import pgmall.mall_4.R;
import pgmall.beacon_mall.activites.shopActivity;


public class showdata_adapter extends RecyclerView.Adapter<showdata_adapter.mViewHolder> {

    private ArrayList<DataModule> dataModuleList;
    Context context;

    public showdata_adapter(Context cont, ArrayList<DataModule> dataModuleList) {

        this.dataModuleList = dataModuleList;
        this.context = cont;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout relativeLayout;

        TextView name_textview;
        ImageView imageView;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            name_textview = itemView.findViewById(R.id.textView1);
            imageView = itemView.findViewById(R.id.image_view_show);
            relativeLayout=itemView.findViewById(R.id.relative_layout);
        }
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        mViewHolder s = new mViewHolder(view);
        return s;
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder mViewHolder, int i) {
        final DataModule module = dataModuleList.get(i);
        mViewHolder.name_textview.setText(module.getName());
        mViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context.getApplicationContext(), shopActivity.class);
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
                    .into(mViewHolder.imageView);
        } catch (Exception e) {
        }
    }

    @Override
    public int getItemCount() {
        return dataModuleList.size();
    }




}

