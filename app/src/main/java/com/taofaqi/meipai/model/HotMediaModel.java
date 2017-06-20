package com.taofaqi.meipai.model;

import com.taofaqi.meipai.bean.ResponseEntity;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public interface HotMediaModel {
    void loadHotMediaDatas(int page, Callback<List<ResponseEntity>> callback);
}
