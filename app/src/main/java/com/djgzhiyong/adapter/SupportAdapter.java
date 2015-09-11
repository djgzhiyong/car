package com.djgzhiyong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.djgzhiyong.happycar.R;
import com.zzy.simplelib.adapter.SimpleAdapter;

import java.util.List;

/**
 * Created by djgzhiyong on 15/9/5.
 */
public class SupportAdapter extends SimpleAdapter<String> {

    public SupportAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public int getCount() {
        return 8;
    }

    private class ViewHolder {
        ImageView iconImageView;
        TextView titleTextView;
    }

    @Override
    public View getItemView(int position, View itemView, ViewGroup viewGroup) {
        ViewHolder mHolder;
        if (itemView == null) {
            mHolder = new ViewHolder();
            itemView = mInflater.inflate(R.layout.item_support, viewGroup, false);
            mHolder.iconImageView = (ImageView) itemView.findViewById(R.id.support_icon);
            mHolder.titleTextView = (TextView) itemView.findViewById(R.id.support_label);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        return itemView;
    }
}
