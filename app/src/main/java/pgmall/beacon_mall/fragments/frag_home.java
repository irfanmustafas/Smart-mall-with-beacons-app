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
import pgmall.beacon_mall.adapters.adapter_fragHome;
import pgmall.mall_4.R;
import pgmall.beacon_mall.activites.activity_shopsList;


public class frag_home extends Fragment implements adapter_fragHome.onItemClick {
    private RecyclerView recyclerView;
    private View view;
    private String[] text = {"cinema", "dinning", "entertainment", "fashion", "optics", "sports wear"};
    private Integer[] images = {R.drawable.ic_film, R.drawable.ic_food, R.drawable.ic_game_controller, R.drawable.fashion_new, R.drawable.ic_reading, R.drawable.ic_football_shirt};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_home, container, false);
        setRecyclerView();
        setOffers();

        return view;
    }
    private void setRecyclerView() {
        recyclerView = view.findViewById(R.id.rv_fragHome);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 2));
        recyclerView.setAdapter(new adapter_fragHome(images, text, this));
    }
    private void setOffers() {
        class ImagePagerAdapter extends PagerAdapter {
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
        ViewPager viewPager = view.findViewById(R.id.fragHome_viewPager_offers);
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);

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
                intent = new Intent(getContext(), activity_shopsList.class);
                intent.putExtra("c", cinema);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getContext(), activity_shopsList.class);
                intent.putExtra("c", dinning);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getContext(), activity_shopsList.class);
                intent.putExtra("c", entertainment);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(getContext(), activity_shopsList.class);
                intent.putExtra("c", fashion);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(getContext(), activity_shopsList.class);
                intent.putExtra("c", optics);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(getContext(), activity_shopsList.class);
                intent.putExtra("c", sportswear);
                startActivity(intent);
                break;

        }
    }
}
