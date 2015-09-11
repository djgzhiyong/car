package com.zzy.simplelib.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;

import com.zzy.simplelib.callback.ShowDialogCallback;

/** 视图控件 */
public class WidgetUtil {

	public static void setWidgetMargin(View view, int top, int right,
			int bottom, int left) {
		LayoutParams ll = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ll.topMargin = top;
		ll.rightMargin = right;
		ll.bottomMargin = bottom;
		ll.leftMargin = left;
		view.setLayoutParams(ll);
	}

	public static void setWidgetMargin(View view, int top, int right,
			int bottom, int left, int width, int height) {
		LayoutParams ll = new LayoutParams(width,
				height);
		ll.topMargin = top;
		ll.rightMargin = right;
		ll.bottomMargin = bottom;
		ll.leftMargin = left;
		view.setLayoutParams(ll);
	}

	public static void showInfoDialog(Context context, String message,
			String buttonLabel, final ShowDialogCallback callback) {

		new AlertDialog.Builder(context).setMessage(message)
				.setPositiveButton(buttonLabel, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface,
							int waich) {
						if (callback != null) {
							callback.positive();
						}
					}
				}).setNegativeButton("取消", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface,
							int waich) {
						if (callback != null) {
							callback.negative();
						}
					}
				}).create().show();
	}
}
