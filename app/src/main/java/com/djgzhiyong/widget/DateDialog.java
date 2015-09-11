package com.djgzhiyong.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.djgzhiyong.happycar.R;

import java.util.Date;

/**
 * Created by djgzhiyong on 15/9/4.
 */
public class DateDialog {

    private Context mContext;
    private AlertDialog.Builder mDialog;
    private View view;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private ActionCall call;

    public DateDialog(Context mContext) {
        this.mContext = mContext;
        mDialog = new AlertDialog.Builder(mContext);
        setup();
    }

    private void setup() {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.dialog_date, null);

        datePicker = (DatePicker) view.findViewById(R.id.datepicker);
        timePicker = (TimePicker) view.findViewById(R.id.timepicker);
        timePicker.setIs24HourView(true);

        mDialog.setView(view);

        mDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String date = datePicker.getYear() + "-" + (datePicker.getMonth() + 1) + "-" + datePicker.getDayOfMonth();
                String time = timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
                call.positiveCall(date +" "+ time);
            }
        });
        mDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                call.negativeCall();
            }
        });


    }

    public void setTitle(String title) {
        mDialog.setTitle(title);
    }

    public void show() {
        if (mDialog != null) {
            mDialog.create().show();
        }
    }

    public void dismiss() {
        mDialog.create().dismiss();
    }

    public void setActionCall(ActionCall call) {
        this.call = call;
    }


    public static interface ActionCall {
        public void positiveCall(String time);

        public void negativeCall();
    }
}
