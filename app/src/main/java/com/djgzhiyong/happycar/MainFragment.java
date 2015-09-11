package com.djgzhiyong.happycar;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.djgzhiyong.adapter.PagerBannerAdapter;
import com.djgzhiyong.widget.BannerPointView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.zzy.simplelib.utils.PlatformUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by djgzhiyong on 15/9/1.
 */
public class MainFragment extends Fragment implements Handler.Callback {

    @ViewInject(R.id.main_viewPager)
    private ViewPager mViewPager;

    @ViewInject(R.id.main_pagerPoint)
    private BannerPointView bannerPoint;

    @ViewInject(R.id.main_marryCar)
    private LinearLayout marryCarView;

    private Handler mHandler;
    private int bannerIndex = 0;
    private List<View> imgs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ViewUtils.inject(this, view);
        setBanner();

        return view;
    }

    @OnClick(R.id.main_marryCar)
    public void marryCarClick(View v) {
        PlatformUtil.jumpActivity(getActivity(), CarListActivity.class);
    }

    @OnClick(R.id.main_businessCar)
    public void businessCarClick(View v) {
        PlatformUtil.jumpActivity(getActivity(), CarListActivity.class);
    }

    @OnClick(R.id.main_special)
    public void specialCarClick(View v) {
        PlatformUtil.jumpActivity(getActivity(), CarListActivity.class);
    }

    @OnClick(R.id.main_longCar)
    public void longCarClick(View v) {
        PlatformUtil.jumpActivity(getActivity(), CarListActivity.class);
    }

    @OnClick(R.id.main_uploadMyCar)
    public void uploadMyCarClick(View v) {
        PlatformUtil.jumpActivity(getActivity(), CarListActivity.class);
    }

    private void setBanner() {
        imgs = new ArrayList<View>();

        ImageView img = new ImageView(getActivity());
        img.setImageDrawable(getResources().getDrawable(R.drawable.banner1));
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgs.add(img);

        img = new ImageView(getActivity());
        img.setImageDrawable(getResources().getDrawable(R.drawable.banner2));
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgs.add(img);

        mViewPager.setAdapter(new PagerBannerAdapter(imgs));
        bannerPoint.setItemCount(imgs.size());

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
        bannerPoint.setItemSelect(bannerIndex);
        return false;
    }
}
