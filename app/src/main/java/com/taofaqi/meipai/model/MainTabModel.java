package com.taofaqi.meipai.model;

import com.taofaqi.meipai.bean.MainTab;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public interface MainTabModel {
    void loadTabDatas(Callback<List<MainTab>> callback);
}
