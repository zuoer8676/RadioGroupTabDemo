/**
 * 
 */
package com.big.demo.util;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.example.radiogrouptabdemo.R;

/**
 * @author 刘赞 2015-6-13
 */
public class DialogUtil {
	private static Dialog progressDialog;

	public static void showLodingDialog(Context context) {
		progressDialog = new Dialog(context, R.style.progress_dialog);
		progressDialog.setContentView(R.layout.dialog);
		progressDialog.setCancelable(true);
		progressDialog.getWindow().setBackgroundDrawableResource(
				android.R.color.transparent);
		TextView msg = (TextView) progressDialog
				.findViewById(R.id.id_tv_loadingmsg);
		msg.setText("卖力加载中");
		progressDialog.show();
	}
	
	public static void dismisDialog(){
		progressDialog.dismiss();
	}
}
