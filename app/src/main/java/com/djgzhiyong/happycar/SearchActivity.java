package com.djgzhiyong.happycar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.djgzhiyong.widget.DateDialog;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.zzy.simplelib.utils.PlatformUtil;

/**
 * Created by djgzhiyong on 15/9/3.
 */
public class SearchActivity extends RootAction {

    @ViewInject(R.id.search_carType)
    private EditText carTypeEditText;

    private DateDialog mDateDialog;

    @Override
    public int setContentViewId() {
        return R.layout.activity_search;
    }

    @Override
    public void create() {

    }

    @OnClick(R.id.search_tackCarTime)
    public void tackCarTime(View v) {
        showDateDialog((EditText) v);
    }

    @OnClick(R.id.search_returnCarTime)
    public void returnCarTime(View v) {
        showDateDialog((EditText) v);
    }

    @OnClick(R.id.search_dayPriceBegin)
    public void dayPriceBegin(View v) {

    }

    @OnClick(R.id.search_dayPriceEnd)
    public void dayPriceEnd(View v) {

    }

    @OnClick(R.id.search_carType)
    public void carType(View v) {
        PlatformUtil.jumpActivity(this, DataSelectActivity.class, RESULT_CARTYPE);
    }

    @OnClick(R.id.search_brand)
    public void carBrand(View v) {

    }

    @OnClick(R.id.search_color)
    public void carColor(View v) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CARTYPE) {
            carTypeEditText.setText(data.getStringExtra("result"));
        }
    }

    private void showDateDialog(final EditText view) {
//        if (mDateDialog == null) {
        mDateDialog = new DateDialog(this);
//        }
        mDateDialog.show();
        mDateDialog.setTitle("选择日期");
        mDateDialog.setActionCall(new DateDialog.ActionCall() {
            @Override
            public void positiveCall(String time) {
                view.setText(time);
            }

            @Override
            public void negativeCall() {

            }
        });
    }

    @Override
    public int setMenuId() {
        return R.menu.search;
    }

    @Override
    public void menuClick(int id) {
        if (id == R.id.action_reset) {

        }
    }

    public static final int RESULT_CARTYPE = 1;

}
