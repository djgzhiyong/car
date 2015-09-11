package com.djgzhiyong.happycar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;


/**
 * Created by djgzhiyong on 15/8/30.
 */
public class SplashActivity extends Activity implements Handler.Callback {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        mHandler = new Handler(this);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0);
            }
        }, 1500);
    }

    @Override
    public boolean handleMessage(Message message) {
        havefun();
        return false;
    }

    private void havefun() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
