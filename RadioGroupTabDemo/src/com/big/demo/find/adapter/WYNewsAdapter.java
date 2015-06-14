/**
 * 
 */
package com.big.demo.find.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

/**
 * @author 刘赞 2015-6-13
 */
public class WYNewsAdapter extends FragmentPagerAdapter {
	private FragmentManager fm;
	private List<Fragment> mListFragment;
	private String[] CONTENT;

	public WYNewsAdapter(FragmentManager fm, List<Fragment> mListFragment,
			String[] CONTENT) {
		// 调用父类的构造函数，一定要卸载构造函数的第一行
		super(fm);
		this.fm = fm;
		this.mListFragment = mListFragment;
		this.CONTENT = CONTENT;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = null;
		fragment = mListFragment.get(position % CONTENT.length);
		Bundle bundle = new Bundle();
		bundle.putString("id", "" + position);
		fragment.setArguments(bundle);
		return fragment;
	}

	@SuppressLint("DefaultLocale")
	@Override
	public CharSequence getPageTitle(int position) {
		return CONTENT[position % CONTENT.length].toUpperCase();
	}

	@Override
	public int getCount() {
		return CONTENT.length;
	}
	/* (non-Javadoc)
	 * @see android.support.v4.view.PagerAdapter#instantiateItem(android.view.View, int)
	 */
	@Override
	public Object instantiateItem(View container, int position) {
		@SuppressWarnings("deprecation")
		Fragment fragment = (Fragment) super.instantiateItem(container,
				position);
		fm.beginTransaction().show(fragment).commit();
		return fragment;
	}
	
	/* (non-Javadoc)
	 * @see android.support.v4.view.PagerAdapter#destroyItem(android.view.View, int, java.lang.Object)
	 */
	@Override
	public void destroyItem(View container, int position, Object object) {
		Fragment fragment = mListFragment.get(position % CONTENT.length);
		fm.beginTransaction().hide(fragment).commit();
	}
}

















