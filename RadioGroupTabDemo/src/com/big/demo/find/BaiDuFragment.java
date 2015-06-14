/**
 * 
 */
package com.big.demo.find;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.big.demo.util.DialogUtil;
import com.example.radiogrouptabdemo.R;

/**
 * @author 刘赞 2015-6-13
 */
public class BaiDuFragment extends Fragment {
	private WebView wv_baidu;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.baidu_fragment, null);
		wv_baidu = (WebView) view.findViewById(R.id.wv_baidu);
		
		initWebView();
		DialogUtil.showLodingDialog(getActivity());
		return view;
	}

	/**
	 * 
	 */
	private void initWebView() {
		// 设置WebView属性，能够执行Javascript脚本
		wv_baidu.getSettings().setJavaScriptEnabled(true);
		// 加载需要显示的网页
		wv_baidu.loadUrl("http://www.baidu.com/");
		// 设置Web视图
		wv_baidu.setWebViewClient(new HelloWebViewClient());

	}

	// 覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && wv_baidu.canGoBack()) {
			wv_baidu.goBack(); // goBack()表示返回WebView的上一页面
			return true;
		}
		return false;
	}

	// Web视图
	private class HelloWebViewClient extends WebViewClient {
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * android.webkit.WebViewClient#onPageStarted(android.webkit.WebView,
		 * java.lang.String, android.graphics.Bitmap)
		 */
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
			// mProgressDialog.setVisibility(View.VISIBLE); // 显示加载界面
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * android.webkit.WebViewClient#onPageFinished(android.webkit.WebView,
		 * java.lang.String)
		 */
		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			DialogUtil.dismisDialog();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * android.webkit.WebViewClient#onReceivedError(android.webkit.WebView,
		 * int, java.lang.String, java.lang.String)
		 */
		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			// TODO Auto-generated method stub
			super.onReceivedError(view, errorCode, description, failingUrl);
			Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_LONG).show();
		}
	}
}
