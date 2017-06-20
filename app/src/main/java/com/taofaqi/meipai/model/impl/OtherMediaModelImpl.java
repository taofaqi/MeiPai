package com.taofaqi.meipai.model.impl;

import com.taofaqi.meipai.bean.ResponseEntity;
import com.taofaqi.meipai.model.OtherMediaModel;
import com.taofaqi.meipai.utils.AppConstants;
import com.taofaqi.meipai.utils.RetrofitUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public class OtherMediaModelImpl implements OtherMediaModel {
    private int id;
    private int type;
    private int page;
    private int count = 10;

    public OtherMediaModelImpl() {
    }

    public OtherMediaModelImpl(int id, int type, int page) {
        this.id = id;
        this.type = type;
        this.page = page;
    }

    @Override
    public void loadOtherMediaDatas(int id,int type,int page,Callback<List<ResponseEntity>> callback) {
        RetrofitUtils.getRetrofit().create(OtherMediaService.class).getOtherMediaDatas(id,type,page,20).enqueue(callback);
    }

    public interface OtherMediaService{
        @GET(AppConstants.RequestPath.VIDEO_LIST+"?")
        Call<List<ResponseEntity>> getOtherMediaDatas(@Query("id") int id, @Query("type") int type, @Query("page") int page, @Query("count") int count);
    }
}
