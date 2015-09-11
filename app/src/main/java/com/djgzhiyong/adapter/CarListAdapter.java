package com.djgzhiyong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.djgzhiyong.happycar.R;
import com.zzy.simplelib.adapter.SimpleAdapter;

import java.util.List;

/**
 * Created by djgzhiyong on 15/9/3.
 */
public class CarListAdapter extends SimpleAdapter<String> {

    private static final int resourceID = R.layout.item_carlist;

    public CarListAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public View getItemView(int position, View itemView, ViewGroup viewGroup) {


        return mInflater.inflate(resourceID, viewGroup
                , false);
    }
}
