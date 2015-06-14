/**
 * 
 */
package com.big.demo.search.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.radiogrouptabdemo.R;

/**
 * @author 刘赞
 * 2015-6-14
 */
public class SearchAdapter extends BaseAdapter{
	List<String> items;
	Context context;

	public SearchAdapter(Context context, List<String> items) {
		this.context = context;
		this.items = items;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(context).inflate(
				R.layout.list_item_layout, null);
		TextView tv = (TextView) view.findViewById(R.id.name_tv);
		tv.setText(items.get(position));
		return view;
	}
}
