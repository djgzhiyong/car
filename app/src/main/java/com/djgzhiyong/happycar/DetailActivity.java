package com.djgzhiyong.happycar;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;

import com.djgzhiyong.adapter.PagerBannerAdapter;
import com.djgzhiyong.adapter.SupportAdapter;
import com.djgzhiyong.widget.NoScrollGridView;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by djgzhiyong on 15/9/5.
 */
public class DetailActivity extends RootAction implements Handler.Callback {

    @ViewInject(R.id.detail_viewpager)
    private ViewPager mViewPager;

    @ViewInject(R.id.details_dayGridview)
    private NoScrollGridView dayGridview;

    @ViewInject(R.id.details_supportGridview)
    private NoScrollGridView supportGridview;

    private Handler mHandler;
    private int bannerIndex = 0;
    private List<View> imgs;

    @Override
    public int setContentViewId() {
        return R.layout.activity_detail;
    }

    @Override
    public void create() {
        mHandler = new Handler(this);
        setBanner();

        List<String> temp = new ArrayList<String>();
        supportGridview.setAdapter(new SupportAdapter(this, temp));
    }

    private void setBanner() {
        imgs = new ArrayList<View>();

        ImageView img = new ImageView(this);
        img.setImageDrawable(getResources().getDrawable(R.drawable.banner1));
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgs.add(img);

        img = new ImageView(this);
        img.setImageDrawable(getResources().getDrawable(R.drawable.banner2));
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgs.add(img);

        mViewPager.setAdapter(new PagerBannerAdapter(imgs));

        startPlayBanner();

    }

    private void startPlayBanner() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0);
            }
        }, 5000);
    }

    @Override
    public boolean handleMessage(Message msg) {
        startPlayBanner();
        bannerIndex++;
        if (bannerIndex == imgs.size()) {
            bannerIndex = 0;
        }
        mViewPager.setCurrentItem(bannerIndex);
        return false;
    }
}
