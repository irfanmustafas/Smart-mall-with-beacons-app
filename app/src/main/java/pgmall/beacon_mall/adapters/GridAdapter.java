package pgmall.beacon_mall.adapters;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pgmall.mall_4.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.gViewHolder> {

    Integer[] image;
    String[] texts;
    private onItemListListener mListener;

    public GridAdapter(Integer[] image,String[] texts, onItemListListener onItemListListener) {
        this.image = image;
        this.texts=texts;
        this.mListener = onItemListListener;
    }

    public GridAdapter(Integer[] images1,String[] texts) {
        this.image = images1;
        this.texts=texts;
    }

    public static class gViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;
        onItemListListener onItemListListener;

        public gViewHolder(@NonNull View itemView, onItemListListener onNoteListListener) {
            super( itemView );
            imageView = itemView.findViewById( R.id.imageView_grid_list_view );
            textView = itemView.findViewById( R.id.textView_grid_list_item );
            this.onItemListListener = onNoteListListener;
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            onItemListListener.onItemClick( getAdapterPosition() );

        }
    }

    @NonNull
    @Override
    public GridAdapter.gViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext() )
                .inflate( R.layout.grid_list_item, viewGroup, false );
//        int height = viewGroup.getMeasuredHeight() / 3;
//        int width = viewGroup.getMeasuredWidth()/2;
      //  v.setLayoutParams(new RecyclerView.LayoutParams(width, height));
        gViewHolder vh = new gViewHolder( v, mListener );
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.gViewHolder gViewHolder, int i) {
        gViewHolder.imageView.setImageResource( image[i] );
        gViewHolder.textView.setText( texts[i] );

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public interface onItemListListener {
        void onItemClick(int postion);
    }
}
