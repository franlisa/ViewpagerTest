package com.example.viewpagertest;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class PageViewAdapter extends PagerAdapter{
	List<View> mList;
	public PageViewAdapter(List<View> list) {
		// TODO Auto-generated constructor stub
		mList=list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}
	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		//return super.instantiateItem(container, position);
		((ViewPager)container).addView(mList.get(position));
		return mList.get(position);
	}
	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
	    ((ViewPager)container).removeView(mList.get(position));
	}

}
