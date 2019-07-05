package pgmall.beacon_mall.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import pgmall.beacon_mall.adapters.GridAdapter;
import pgmall.mall_4.R;
import pgmall.beacon_mall.show_data;


public class frag_home extends Fragment implements GridAdapter.onItemListListener {
    private RecyclerView mRecyclerView;
    ////////////////////////////////////////////for this activity/////////////////////////////////////////////
    public String[] text = {"cinema", "dinning", "entertainment", "fashion", "optics", "sports wear"};
    public Integer[] images = {R.drawable.ic_film, R.drawable.ic_food, R.drawable.ic_game_controller, R.drawable.fashion_new,
            R.drawable.ic_reading, R.drawable.ic_football_shirt};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        mRecyclerView = view.findViewById(R.id.frag_home_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 2));
        mRecyclerView.setAdapter(new GridAdapter(images, text, this));
        ViewPager viewPager = view.findViewById(R.id.pager1);
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);
        return view;
    }

    private class ImagePagerAdapter extends PagerAdapter {
        private int[] mImages = new int[]{
                R.drawable.offer5,
                R.drawable.offer6,
                R.drawable.offer3,
                R.drawable.offer4
        };

        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView imageView = new ImageView(getContext());
            int padding = getContext().getResources().getDimensionPixelSize(
                    R.dimen.fab_margin);
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(mImages[position]);
            (container).addView(imageView, 0);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            (container).removeView((ImageView) object);
        }
    }


    @Override
    public void onItemClick(int postion) {
        Intent intent;
        String cinema, dinning, entertainment, fashion, optics, sportswear;
        cinema = "cinema";
        dinning = "dinning";
        entertainment = "entertainment";
        fashion = "fashion";
        optics = "optics";
        sportswear = "sportwear";
        switch (postion) {
            case 0:
                intent = new Intent(getContext(), show_data.class);
                intent.putExtra("c", cinema);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getContext(), show_data.class);
                intent.putExtra("c", dinning);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getContext(), show_data.class);
                intent.putExtra("c", entertainment);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(getContext(), show_data.class);
                intent.putExtra("c", fashion);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(getContext(), show_data.class);
                intent.putExtra("c", optics);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(getContext(), show_data.class);
                intent.putExtra("c", sportswear);
                startActivity(intent);
                break;

        }
    }
}
