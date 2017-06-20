package com.taofaqi.meipai.presenter.impl;

import com.taofaqi.meipai.bean.MainTab;
import com.taofaqi.meipai.model.MainTabModel;
import com.taofaqi.meipai.model.impl.MainTabModelImpl;
import com.taofaqi.meipai.presenter.MainTabPresenter;
import com.taofaqi.meipai.view.MainTabView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public class MainTabPresenterImpl implements MainTabPresenter {

    MainTabModel mainTabModel;
    MainTabView mainTabView;

    public MainTabPresenterImpl(MainTabView mainTabView) {
        mainTabModel = new MainTabModelImpl();
        this.mainTabView = mainTabView;
    }

    @Override
    public void loadMainTabDatas() {
        mainTabModel.loadTabDatas(new Callback<List<MainTab>>() {
            @Override
            public void onResponse(Call<List<MainTab>> call, Response<List<MainTab>> response) {
                List<MainTab> mainTabs = response.body();
                mainTabView.showTabDatas(mainTabs);
            }

            @Override
            public void onFailure(Call<List<MainTab>> call, Throwable t) {
                mainTabView.showErrorMsg();
            }
        });
    }
}
