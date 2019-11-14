package pgmall.beacon_mall.adapters;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import pgmall.mall_4.R;

public class adapter_fragHome extends RecyclerView.Adapter<adapter_fragHome.mVH> {
    private Integer[] image;
    private String[] texts;
    private onItemClick onItemClick;

    public adapter_fragHome(Integer[] image, String[] texts, onItemClick onItemClick) {
        this.image = image;
        this.texts = texts;
        this.onItemClick = onItemClick;
    }

    public static class mVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView textView;
        onItemClick onItemClick;

        public mVH(@NonNull View itemView, onItemClick onNoteListListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.fragHome_item_iv);
            textView = itemView.findViewById(R.id.fragHome_Item_tv);
            this.onItemClick = onNoteListListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClick.onItemClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_rv_frag_home, viewGroup, false);
        mVH vh = new mVH(v, onItemClick);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull mVH mVH, int i) {
        mVH.imageView.setImageResource(image[i]);
        mVH.textView.setText(texts[i]);

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public interface onItemClick {
        void onItemClick(int position);
    }
}
