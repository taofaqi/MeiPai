package com.taofaqi.meipai.view;

import com.taofaqi.meipai.bean.MainTab;

import java.util.List;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public interface MainTabView {
    void showTabDatas(List<MainTab> mainTabs);
    void showErrorMsg();
}
