package com.example.viewpagertest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class PagerTabStripActivity extends Activity {
	private ViewPager mViewPager;
	private List<View> mList;
	private List<String> mTabName;
	private PageViewAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pagertabstrip_layout);
		initView();
		
	}
	@SuppressWarnings("deprecation")
	private void initView() {
		// TODO Auto-generated method stub
		mViewPager=(ViewPager)findViewById(R.id.viewPager);
		mList = new ArrayList<>();
		mList.add(getLayoutInflater().inflate(R.layout.page1_layout, null));
		mList.add(getLayoutInflater().inflate(R.layout.page2_layout, null));
		mList.add(getLayoutInflater().inflate(R.layout.page3_layout, null));
		mTabName = new ArrayList<>();
		mTabName.add("首页");
		mTabName.add("评论");
		mTabName.add("私信");
		mAdapter=new PageViewTabStripAdapter(mList,mTabName);
//		PagerAdapter adapter = new  PagerAdapter() {
//			
//			@Override
//			public boolean isViewFromObject(View arg0, Object arg1) {
//				// TODO Auto-generated method stub
//				return arg0 == mList.get((int)Integer.parseInt(arg1.toString()));
//			}
//			
//			@Override
//			public int getCount() {
//				// TODO Auto-generated method stub
//				return mList.size();
//			}
//			@Override
//			public void destroyItem(ViewGroup container, int position, Object object) {
//				// TODO Auto-generated method stub
//				container.removeView(mList.get(position));
//			}
//			@Override
//			public Object instantiateItem(ViewGroup container, int position) {
//				// TODO Auto-generated method stub
//				container.addView(mList.get(position));
//				return position;//这个就是每个pageview的key
//			}
//			@Override
//			public CharSequence getPageTitle(int position) {
//				// TODO Auto-generated method stub
//				return mTabName.get(position);
//			}
//			
//		};
		mViewPager.setAdapter(mAdapter);
		mViewPager.setCurrentItem(2);
		
		
	}

}
