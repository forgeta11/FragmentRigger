package com.yj.app.test.lazyload;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import com.yj.app.R;
import com.yj.app.base.BaseFragment;

/**
 * @author JingYeoh
 *         <a href="mailto:yangjing9611@foxmail.com">Email me</a>
 *         <a href="https://github.com/justkiddingbaby">Github</a>
 *         <a href="http://blog.justkiddingbaby.com">Blog</a>
 * @since Dec 04,2017
 */

public class LazyLoadFragment extends BaseFragment {

  public static LazyLoadFragment newInstance() {
    Bundle args = new Bundle();
    LazyLoadFragment fragment = new LazyLoadFragment();
    fragment.setArguments(args);
    return fragment;
  }

  private ViewPager viewPager;
  private TabLayout tabLayout;
  private LazyLoadAdapter lazyLoadAdapter;

  @Override
  protected int getContentView() {
    return R.layout.frg_lazyload;
  }

  @Override
  protected void init(Bundle savedInstanceState) {
    initView();
    lazyLoadAdapter = new LazyLoadAdapter(getChildFragmentManager());
    viewPager.setAdapter(lazyLoadAdapter);
    tabLayout.setupWithViewPager(viewPager);
    viewPager.setOffscreenPageLimit(4);
  }

  private void initView() {
    viewPager = (ViewPager) findViewById(R.id.fl_vp);
    tabLayout = (TabLayout) findViewById(R.id.fl_tab);
    tabLayout.addTab(tabLayout.newTab());
    tabLayout.addTab(tabLayout.newTab());
    tabLayout.addTab(tabLayout.newTab());
    tabLayout.addTab(tabLayout.newTab());
  }
}