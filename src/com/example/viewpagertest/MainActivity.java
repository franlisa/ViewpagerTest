package com.example.viewpagertest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ViewPager mViewpager;
	private TextView mTextView0;
	private TextView mTextView1;
	private TextView mTextView2;
	private View mCursor;
	private List<View> mPageList;
	private PageViewAdapter mAdapter;
    private int mOffset;
    private int mCusorWidth;
    private int mCurrentIndex;
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager_main);
		initView();
		initCursor();
		initViewPager();
		mTextView0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mViewpager.setCurrentItem(0);
			}
		});
		mTextView1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mViewpager.setCurrentItem(1);
			}
		});
		mTextView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mViewpager.setCurrentItem(2);
			}
		});
		
	}
	private void initView(){
		mTextView0=(TextView)findViewById(R.id.pager0);
		mTextView1=(TextView)findViewById(R.id.pager1);
		mTextView2=(TextView)findViewById(R.id.pager2);
		
	}
	@SuppressWarnings("deprecation")
	private void initViewPager(){
		mViewpager = (ViewPager)findViewById(R.id.viewPager);
		mPageList = new ArrayList<>();
		mPageList.add(getLayoutInflater().inflate(R.layout.page1_layout, null));
		mPageList.add(getLayoutInflater().inflate(R.layout.page2_layout, null));
		mPageList.add(getLayoutInflater().inflate(R.layout.page3_layout, null));
		mAdapter=new PageViewAdapter(mPageList);
		mViewpager.setAdapter(mAdapter);
		
		mViewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				Animation mAnimation = null;
				switch (arg0) {
				case 0:
					if(mCurrentIndex==1){
						mAnimation=new TranslateAnimation(mCusorWidth+2*mOffset, 0, 0, 0);
					}else if(mCurrentIndex==2)
						mAnimation= new TranslateAnimation(mCusorWidth*2+4*mOffset,0,0,0);
					break;
				case 1:
					if(mCurrentIndex == 0)
						mAnimation = new TranslateAnimation(0, mCusorWidth+2*mOffset, 0, 0);
					else if(mCurrentIndex == 2)
						mAnimation = new TranslateAnimation(mCusorWidth*2+4*mOffset,mCusorWidth+2*mOffset,0,0);
				    break;
				case 2:
					if(mCurrentIndex == 0)
						mAnimation = new TranslateAnimation(mCusorWidth+2*mOffset,mCusorWidth*2+4*mOffset, 0, 0);
					else if(mCurrentIndex == 1)
						mAnimation = new TranslateAnimation(mCusorWidth+2*mOffset,mCusorWidth*2+4*mOffset,0,0);
					break;

			    }
				mAnimation.setDuration(200);
				mAnimation.setFillAfter(true);
				mCursor.setAnimation(mAnimation);
				mCurrentIndex=arg0;
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    
		
		
	}
	private void initCursor() {
		// TODO Auto-generated method stub
		mCursor = (View) findViewById(R.id.cursior);
		
		int screenWidth=getResources().getDisplayMetrics().widthPixels;
		mCusorWidth=mCursor.getLayoutParams().width;
		mOffset=(screenWidth/3-mCusorWidth)/2;
		//Matrix matrix=new Matrix();
		//matrix.setTranslate(mOffset,0);
		mCursor.setTranslationX(mOffset);
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
