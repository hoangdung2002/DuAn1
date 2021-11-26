package com.bai.duan1_cp16306_nhom2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bai.duan1_cp16306_nhom2.Adapter.IntroViewPagerAdapter;
import com.bai.duan1_cp16306_nhom2.Model.ScreenItem;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class IntroActivity extends AppCompatActivity {
    Button btnNext;
    TextView tvSkip;

    private IntroViewPagerAdapter adapter;
    private CircleIndicator circleIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        circleIndicator = findViewById(R.id.circle_Indicator);
        btnNext = findViewById(R.id.btn_next);
        tvSkip = findViewById(R.id.tv_skip);

        setupOnboardingItems();

        final ViewPager2 viewPager2 = findViewById(R.id.screen_viewpager);
        viewPager2.setAdapter(adapter);

        setupOnboardingIndicators();
        setCurentIndicators(0);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurentIndicators(position);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager2.getCurrentItem() + 1 < adapter.getItemCount()) {
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                }else {
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    finish();
                }
            }
        });

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setupOnboardingItems () {
        List<ScreenItem> list = new ArrayList<>();

        ScreenItem item = new ScreenItem();
        item.setTitle("Fresh Food");
        item.setDescription("Đồ ăn ngon");
        item.setScreenImg(R.drawable.img1);

        ScreenItem item1 = new ScreenItem();
        item1.setTitle("Fast Delivery");
        item1.setDescription("Giao Hàng nhanh");
        item1.setScreenImg(R.drawable.img2);

        ScreenItem item2 = new ScreenItem();
        item2.setTitle("Easy Payment");
        item2.setDescription("Thanh toán tiện ích");
        item2.setScreenImg(R.drawable.img3);

        list.add(item);
        list.add(item1);
        list.add(item2);

        adapter = new IntroViewPagerAdapter(list);
    }

    private void setupOnboardingIndicators () {
        ImageView[] imgIndicators = new ImageView[adapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < imgIndicators.length; i++) {
            imgIndicators[i] = new ImageView(getApplicationContext());
            imgIndicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.indicator_selected
            ));
            imgIndicators[i].setLayoutParams(layoutParams);
            circleIndicator.addView(imgIndicators[i]);
        }
    }

    private void setCurentIndicators ( int index){
        int childCount = circleIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) circleIndicator.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getApplicationContext(), R.drawable.indicator_selector
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getApplicationContext(), R.drawable.indicator_selected
                ));
            }
            if(index == adapter.getItemCount() - 1){
                btnNext.setText("Start");
            }else {
                btnNext.setText("Next ->");
            }
        }
    }
}