package com.practice.imagesliderwithviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomSwipePagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] arrayImages;
    private LayoutInflater layoutInflater;

    public CustomSwipePagerAdapter(Context mContext, int[] imagesArray) {
        this.mContext = mContext;
        this.arrayImages = imagesArray;
    }

    @Override
    public int getCount() {
        return arrayImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //View itemView = LayoutInflater.from(mContext).inflate(R.layout.swipe_image_layout, container, false);
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = layoutInflater.inflate(R.layout.swipe_image_layout, container, false);
        ImageView imageView = itemView.findViewById(R.id.image_view);
        TextView tvCounter = itemView.findViewById(R.id.tv_counter);

        imageView.setImageResource(arrayImages[position]);
        tvCounter.setText("Image No. " + (position + 1));

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
