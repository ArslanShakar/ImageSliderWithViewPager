package com.practice.imagesliderwithviewpager;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CustomSwipePagerAdapter adapter;
    private int[] arrayImages;
    private int currentPosition = 0;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        arrayImages = new int[]{R.drawable.one, R.drawable.three, R.drawable.two, R.drawable.four};
        adapter = new CustomSwipePagerAdapter(this, arrayImages);

        viewPager.setAdapter(adapter);

        createSlideShow();

        //Toast.makeText(this, viewPager.getChildAt(V)+"", Toast.LENGTH_SHORT).show();
    }

    private void createSlideShow()
    {
        final Handler handler = new Handler();

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                if(currentPosition == arrayImages.length)
                {
                    currentPosition = 0;
                    viewPager.setCurrentItem(currentPosition++, true);
                }else
                {
                    viewPager.setCurrentItem(currentPosition++, true);
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 250, 3000);
    }
}
