package com.taofaqi.meipai.presenter.impl;

import com.taofaqi.meipai.bean.ResponseEntity;
import com.taofaqi.meipai.model.OtherMediaModel;
import com.taofaqi.meipai.model.impl.OtherMediaModelImpl;
import com.taofaqi.meipai.presenter.OtherMediaPresenter;
import com.taofaqi.meipai.view.OtherMediaView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public class OtherMediaPresenterImpl implements OtherMediaPresenter {

    OtherMediaView otherMediaView;
    OtherMediaModel otherMediaModel;

    public OtherMediaPresenterImpl(OtherMediaView otherMediaView) {
        this.otherMediaView = otherMediaView;

        otherMediaModel = new OtherMediaModelImpl();
    }

    @Override
    public void loadOtherMediaDatas(int id, int type ,int page) {
        otherMediaModel.loadOtherMediaDatas(id,type,page,new Callback<List<ResponseEntity>>() {
            @Override
            public void onResponse(Call<List<ResponseEntity>> call, Response<List<ResponseEntity>> response) {
                List<ResponseEntity> otherEntities = response.body();
                otherMediaView.showOtherMeidaDatas(otherEntities);
            }

            @Override
            public void onFailure(Call<List<ResponseEntity>> call, Throwable t) {
                otherMediaView.showErrorMsg();
            }
        });
    }
}
