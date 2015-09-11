package com.djgzhiyong.happycar;


import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.djgzhiyong.adapter.CarListAdapter;
import com.djgzhiyong.adapter.MySpinnerAdapter;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.zzy.simplelib.utils.PlatformUtil;

import java.util.ArrayList;
import java.util.List;

import static android.app.ActionBar.NAVIGATION_MODE_LIST;

/**
 * Created by djgzhiyong on 15/9/3.
 */
public class CarListActivity extends RootAction implements SwipeRefreshLayout.OnRefreshListener {

//    @ViewInject(R.id.carlist_recyclerview)
//    private RecyclerView mRecyclerView;

    @ViewInject(R.id.carlist_brand)
    private Spinner brandSpinner;

    @ViewInject(R.id.carlist_carType)
    private Spinner carTypeSpinner;

    @ViewInject(R.id.carlist_price)
    private Spinner priceSpinner;

    @ViewInject(R.id.carlist_recyclerview)
    private ListView listView;

    @ViewInject(R.id.carlist_swipeRefersh)
    private SwipeRefreshLayout mSwipeRefreshLayout;

//    private RecyclerView.LayoutManager layoutManager;
//    private RecyclerView.Adapter adapter;

    @Override
    public int setContentViewId() {
        return R.layout.activity_carlist;
    }

    @Override
    public void create() {
        setTitle("婚宴租车");
        setActionBar();

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.redSecondColor,R.color.redColor,R.color.redColor);

        setListData();

        setBrandData();
        setCarTypeData();
        setPriceData();

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }

    private void setActionBar() {
        mActionBar.setNavigationMode(NAVIGATION_MODE_LIST);

        List<String> data = new ArrayList<String>();
        data.add("武汉");
        data.add("上海");
        data.add("深圳");
        data.add("广州");
        MySpinnerAdapter adapter = new MySpinnerAdapter(this, data, true);
        mActionBar.setListNavigationCallbacks(adapter, new ActionBar.OnNavigationListener() {
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                return false;
            }
        });
    }

    private void setBrandData() {
        List<String> data = new ArrayList<String>();
        data.add("品牌");
        data.add("奔驰");
        data.add("宝马");
        data.add("奥迪");
        data.add("保时捷");
        data.add("法拉利");
        brandSpinner.setAdapter(new MySpinnerAdapter(this, data));
    }

    private void setCarTypeData() {
        List<String> data = new ArrayList<String>();
        data.add("车型");
        data.add("轿车");
        data.add("跑车");
        data.add("房车");
        data.add("SUV");
        data.add("加长");
        carTypeSpinner.setAdapter(new MySpinnerAdapter(this, data));
    }

    private void setPriceData() {
        List<String> data = new ArrayList<String>();
        data.add("价格");
        data.add("由高到低");
        data.add("由低到高");
        priceSpinner.setAdapter(new MySpinnerAdapter(this, data));
    }

    @Override
    public int setMenuId() {
        return R.menu.carlist;
    }


    @Override
    public void menuClick(int id) {
        if (id == R.id.action_find) {
            PlatformUtil.jumpActivity(this, SearchActivity.class);
        }
    }

    private void setListData() {
        List<String> temp = new ArrayList<String>();
        temp.add("");
        temp.add("");
        temp.add("");
        temp.add("");
        temp.add("");
//        mRecyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(layoutManager);
//        adapter = new MyRecyclerAdapter(temp);
//        mRecyclerView.setAdapter(adapter);

        listView.setAdapter(new CarListAdapter(this, temp));
    }


    @OnItemClick(R.id.carlist_recyclerview)
    public void itemClick(AdapterView<?> av, View v, int position, long id) {
        PlatformUtil.jumpActivity(this, DetailActivity.class);
    }


}
