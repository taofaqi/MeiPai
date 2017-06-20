package com.taofaqi.meipai.presenter.impl;

import com.taofaqi.meipai.bean.ResponseEntity;
import com.taofaqi.meipai.model.HotMediaModel;
import com.taofaqi.meipai.model.impl.HotMediaModelImpl;
import com.taofaqi.meipai.presenter.HotMediaPresenter;
import com.taofaqi.meipai.view.HotMediaView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public class HotMediaPresenterImpl implements HotMediaPresenter {
    HotMediaView hotMediaView;
    HotMediaModel hotMediaModel;

    public HotMediaPresenterImpl(HotMediaView hotMediaView) {
        this.hotMediaView = hotMediaView;
        hotMediaModel = new HotMediaModelImpl();
    }


    @Override
    public void loadHotMediaDatas(int page) {
        hotMediaModel.loadHotMediaDatas(page,new Callback<List<ResponseEntity>>() {
            @Override
            public void onResponse(Call<List<ResponseEntity>> call, Response<List<ResponseEntity>> response) {
                List<ResponseEntity> hotEntities = response.body();
                hotMediaView.showHotMedia(hotEntities);
            }

            @Override
            public void onFailure(Call<List<ResponseEntity>> call, Throwable t) {
                hotMediaView.showErrorMsg();
            }
        });
    }
}
