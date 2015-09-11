package com.djgzhiyong.happycar;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by djgzhiyong on 15/9/4.
 */
public class DataSelectActivity extends RootAction {

    @ViewInject(R.id.data_select_list)
    private ListView mListView;

    @Override
    public int setContentViewId() {
        return R.layout.activity_data_select;
    }


    private List<String> tempData;

    @Override
    public void create() {
        tempData = new ArrayList<String>();

        addCarTypeData();
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tempData));
    }

    private void addCarTypeData() {
        tempData.add("不限");
        tempData.add("轿车");
        tempData.add("跑车");
        tempData.add("SUV");
        tempData.add("加长");
    }

    @OnItemClick(R.id.data_select_list)
    public void itemClick(AdapterView<?> av, View v, int position, long id) {

        Intent intent = new Intent();
        intent.putExtra("result", tempData.get(position));
        setResult(SearchActivity.RESULT_CARTYPE, intent);

        finish();
    }


}
