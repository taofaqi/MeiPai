package com.taofaqi.meipai.model.impl;

import com.taofaqi.meipai.bean.MainTab;
import com.taofaqi.meipai.model.MainTabModel;
import com.taofaqi.meipai.utils.AppConstants;
import com.taofaqi.meipai.utils.RetrofitUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by CrazyForUu on 2016/3/12.
 * In the Model layer need to create a callback interface, used to notify the Presenter layer data is loaded
 */
public class MainTabModelImpl implements MainTabModel {

    @Override
    public void loadTabDatas(Callback<List<MainTab>> callback) {
        RetrofitUtils.getRetrofit().create(MainTabService.class).getMainTabDatas().enqueue(callback);
    }

    public interface MainTabService{
        @GET(AppConstants.RequestPath.CATEGOTY_URL)
        Call<List<MainTab>> getMainTabDatas();
    }
}
