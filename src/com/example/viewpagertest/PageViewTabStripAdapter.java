package com.example.viewpagertest;

import java.util.List;
import android.view.View;

public class PageViewTabStripAdapter extends PageViewAdapter {
    private List<String> mTabName;
	public PageViewTabStripAdapter(List<View> list,List<String> tabName) {
		super(list);
		mTabName = tabName;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return mTabName.get(position);
	}
	

}
