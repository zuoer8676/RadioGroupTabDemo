package fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.big.demo.find.BaiDuFragment;
import com.big.demo.find.JiDongFragment;
import com.big.demo.find.TaoBaoFragment;
import com.big.demo.find.adapter.WYNewsAdapter;
import com.example.radiogrouptabdemo.R;
import com.viewpagerindicator.TabPageIndicator;

/**
 * Created by smyh on 2015/4/28.
 */
public class FindFagment extends Fragment {
	private static final String[] CONTENT = new String[] { "头条", "娱乐", "体育"};
	private List<Fragment> mListFragment = new ArrayList<Fragment>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_find, null);
		TabPageIndicator titleIndicator = (TabPageIndicator) view
				.findViewById(R.id.titles);
		ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
		viewPager.setOffscreenPageLimit(2); 
		initFragment();
		FragmentPagerAdapter adapter = new WYNewsAdapter(getFragmentManager(),mListFragment,CONTENT);
		viewPager.setAdapter(adapter);
		 
		titleIndicator.setViewPager(viewPager);
		return view;
	}

	/**
	 * 
	 */
	private void initFragment() {
		BaiDuFragment mBaiDuFragment = new BaiDuFragment();
		TaoBaoFragment mTaoBaoFragment = new TaoBaoFragment();
		JiDongFragment mJiDongFragment = new JiDongFragment();
		mListFragment.add(mBaiDuFragment);
		mListFragment.add(mTaoBaoFragment);
		mListFragment.add(mJiDongFragment);
		
	}

	// 重写setMenuVisibility方法，不然会出现叠层的现象
	@Override
	public void setMenuVisibility(boolean menuVisibile) {
		super.setMenuVisibility(menuVisibile);
		if (this.getView() != null) {
			this.getView().setVisibility(
					menuVisibile ? View.VISIBLE : View.GONE);
		}
	}

	
}
