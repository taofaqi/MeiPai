package com.taofaqi.meipai.model;

import com.taofaqi.meipai.bean.ResponseEntity;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public interface OtherMediaModel {
    void loadOtherMediaDatas(int id, int type, int page, Callback<List<ResponseEntity>> callback);

}
