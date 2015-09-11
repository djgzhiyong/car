package com.djgzhiyong.happycar;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.logging.Handler;

import android.os.Handler.*;

/**
 * Created by djgzhiyong on 15/9/4.
 */
public class CheckUpdateFragment extends Fragment implements Callback {

    @ViewInject(R.id.check_update_bar)
    private ProgressBar mProgressbar;

    @ViewInject(R.id.check_update_detail)
    private TextView detailTextView;

    @ViewInject(R.id.check_update_download)
    private Button btnDownload;

    private android.os.Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new android.os.Handler(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_check_update, container, false);
        ViewUtils.inject(this, view);

        getAppUpdate();
        return view;
    }

    private void getAppUpdate() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0);
            }
        }, 2000);
    }


    @Override
    public boolean handleMessage(Message msg) {
        btnDownload.setVisibility(View.VISIBLE);
        mProgressbar.setVisibility(View.INVISIBLE);
        detailTextView.setText("最新版本2.0 \n 1.增加新的数据支持;\n2.覆盖更多城市;");
        return false;
    }
}
