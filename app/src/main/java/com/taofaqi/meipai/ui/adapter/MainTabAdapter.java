package com.taofaqi.meipai.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public class MainTabAdapter extends FragmentPagerAdapter {

    private ArrayList<String> datas;
    private ArrayList<Fragment> fragments;

    public MainTabAdapter(FragmentManager fm, ArrayList<String> datas, ArrayList<Fragment> fragments) {
        super(fm);
        this.datas = datas;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments != null ? fragments.get(position) : null;
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return datas!=null?datas.get(position):null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
