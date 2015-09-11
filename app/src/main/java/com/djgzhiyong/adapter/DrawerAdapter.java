package com.djgzhiyong.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.djgzhiyong.happycar.R;
import com.djgzhiyong.viewmodel.MenuModel;

import java.util.List;

/**
 * Created by djgzhiyong on 15/9/1.
 */
public class DrawerAdapter extends ArrayAdapter<MenuModel> {

    private static final int rescourceID = R.layout.item_drawer;
    private LayoutInflater mInflater;
    private Context mContext;

    public DrawerAdapter(Context context, List<MenuModel> menuModels) {
        super(context, rescourceID, menuModels);
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    private class ViewHolder {
        ImageView iconImageView;
        TextView titleTextView;
        TextView labelTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(rescourceID, parent, false);
            mHolder = new ViewHolder();
            mHolder.iconImageView = (ImageView) convertView.findViewById(R.id.drawer_icon);
            mHolder.titleTextView = (TextView) convertView.findViewById(R.id.drawer_title);
            mHolder.labelTextView = (TextView) convertView.findViewById(R.id.drawer_label);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        MenuModel mm = getItem(position);
        mHolder.titleTextView.setText(mm.title);
        if (mm.label != null) {
            mHolder.labelTextView.setText(mm.label);
        } else {
            mHolder.labelTextView.setText("");
        }
        mHolder.iconImageView.setImageDrawable(mContext.getResources().getDrawable(mm.icon));
        return convertView;
    }
}
