package com.taofaqi.meipai.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.taofaqi.meipai.R;
import com.taofaqi.meipai.bean.MainTab;
import com.taofaqi.meipai.bean.URLEntity;
import com.taofaqi.meipai.presenter.MainTabPresenter;
import com.taofaqi.meipai.presenter.impl.MainTabPresenterImpl;
import com.taofaqi.meipai.ui.adapter.MainTabAdapter;
import com.taofaqi.meipai.ui.fragments.HotFragment;
import com.taofaqi.meipai.ui.fragments.OtherFragment;
import com.taofaqi.meipai.view.MainTabView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,MainTabView {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.main_tabLayout)
    TabLayout mainTabLayout;
    @Bind(R.id.main_Viewpager)
    ViewPager mainViewpager;
    @Bind(R.id.main_content)
    CoordinatorLayout mainContent;
    @Bind(R.id.main_drawer_layout)
    DrawerLayout mainDrawerLayout;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;

    private MainTabPresenter mainTabPresenter;
    private MainTabAdapter mainTabAdapter;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> mainTabDatas;
    private ArrayList<URLEntity> urlEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        initDatas();
    }

    private void initDatas() {
        mainTabPresenter = new MainTabPresenterImpl(this);
        mainTabPresenter.loadMainTabDatas();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showTabDatas(List<MainTab> mainTabs) {
        int j = 0;
        urlEntities = new ArrayList<>();
        updateURL(mainTabs);
        fragments = new ArrayList<>();
        mainTabDatas = new ArrayList<>();
        for (int i= 0;i < mainTabs.size();i++){
            MainTab mainTab = mainTabs.get(i);
            String name = mainTab.getName();
            if (i == 0) {
                name.replace("#", "");
                fragments.add(HotFragment.newInstance());
            }else {
                OtherFragment otherFragment = OtherFragment.newInstance(urlEntities.get(j++));
//                list.clear();
                fragments.add(otherFragment);
            }
            mainTabDatas.add(name);
        }
        mainTabAdapter = new MainTabAdapter(getSupportFragmentManager(),mainTabDatas,fragments);
        mainViewpager.setAdapter(mainTabAdapter);
        mainTabLayout.setupWithViewPager(mainViewpager);  //设置ViewPager和TabLayout的上下联动
    }

    private void updateURL(List<MainTab> mainTabs) {
        urlEntities = new ArrayList<>();
        for (int i= 1;i < mainTabs.size();i++) {
            MainTab mainTab = mainTabs.get(i);
            urlEntities.add(new URLEntity(mainTab.getId(),mainTab.getType()));
        }
    }

    @Override
    public void showErrorMsg() {
        Toast.makeText(MainActivity.this, "数据加载失败", Toast.LENGTH_SHORT).show();
    }
}