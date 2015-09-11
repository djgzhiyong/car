package com.djgzhiyong.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.djgzhiyong.happycar.R;
import com.zzy.simplelib.adapter.SimpleAdapter;

import java.util.List;

/**
 * Created by djgzhiyong on 15/9/4.
 */
public class MySpinnerAdapter extends SimpleAdapter<String> {

    private boolean isLight;

    public MySpinnerAdapter(Context context, List<String> data) {
        super(context, data);
    }

    public MySpinnerAdapter(Context context, List<String> data, boolean isLight) {
        super(context, data);
        this.isLight = isLight;
    }


    @Override
    public View getItemView(int position, View itemView, ViewGroup viewGroup) {
        TextView textView;
        if (itemView == null) {
            itemView = mInflater.inflate(R.layout.item_spinner, viewGroup, false);
            textView = (TextView) itemView.findViewById(R.id.spinner_text);
            itemView.setTag(textView);
        } else {
            textView = (TextView) itemView.getTag();
        }
        textView.setText(getItem(position));
        if (isLight) {
            textView.setTextColor(Color.WHITE);
        } else {
            textView.setTextColor(Color.BLACK);
        }
        return itemView;
    }
}
