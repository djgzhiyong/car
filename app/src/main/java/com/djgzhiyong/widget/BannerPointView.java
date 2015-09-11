package com.djgzhiyong.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.djgzhiyong.happycar.R;

/**
 * Created by Administrator on 2015-09-10 0010.
 */
public class BannerPointView extends LinearLayout {

    private RadioGroup radioGroup;

    private Context context;

    private int itemCount;

    public BannerPointView(Context context) {
        super(context);
        init(context);
    }

    public BannerPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BannerPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        this.context = context;
        radioGroup = new RadioGroup(context);
        radioGroup.setOrientation(HORIZONTAL);
        radioGroup.setBackgroundColor(Color.BLACK);
        radioGroup.setAlpha(0.5f);
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
        for (int i = 0; i < itemCount; i++) {

            RadioButton radioButton = new RadioButton(context);
            radioButton.setButtonDrawable(R.drawable.point_select);
            radioButton.setBackgroundDrawable(new BitmapDrawable());
            radioButton.setChecked(false);
            radioGroup.addView(radioButton);
        }
    }

    public void setItemSelect(int index) {
        RadioButton radioButton = (RadioButton) radioGroup.getChildAt(index);
        radioButton.setChecked(true);
    }


}
