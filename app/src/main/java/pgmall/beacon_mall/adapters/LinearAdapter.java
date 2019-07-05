package pgmall.beacon_mall.adapters;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pgmall.mall_4.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.mViewHolder> {
    private item itemFirst;
    String[] text ;
    int[] image;


    public LinearAdapter(String[] text, int[] image, LinearAdapter.item item) {
        this.itemFirst = item;
        this.text = text;
        this.image = image;
    }
    public LinearAdapter(String[] text, int[] image) {
        this.text = text;
        this.image = image;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        item item;
        public TextView textView1, textView2;
        public ImageView imageView;


        public mViewHolder(View itemView, item item1) {
            super(itemView);
//            textView1 = itemView.findViewById(R.id.textView1_linear_list_item);
//            textView2 = itemView.findViewById(R.id.textView2_linear_list_item);
//            imageView = itemView.findViewById(R.id.image_linear_list_item);

            this.item = item1;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            item.onItemClick(getAdapterPosition());

        }
    }

    @NonNull
    @Override
    public LinearAdapter.mViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.linear_list_item, viewGroup, false);
        mViewHolder vh = new mViewHolder(v, itemFirst);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.mViewHolder mViewHolder, int position) {

        mViewHolder.textView1.setText(text[position]);
        mViewHolder.textView2.setText(text[position]);
        mViewHolder.imageView.setImageResource(image[position]);


    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    public interface item {

        void onItemClick(int position);
    }

}
