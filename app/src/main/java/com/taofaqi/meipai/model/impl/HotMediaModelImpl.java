package com.taofaqi.meipai.model.impl;

import com.taofaqi.meipai.bean.ResponseEntity;
import com.taofaqi.meipai.model.HotMediaModel;
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
public class HotMediaModelImpl implements HotMediaModel {
    @Override
    public void loadHotMediaDatas(int page,Callback<List<ResponseEntity>> callback) {
        RetrofitUtils.getRetrofit().create(HotMediaService.class).getHotMediaDatas(1,2,page,20).enqueue(callback);
    }

    public interface HotMediaService{
        @GET(AppConstants.RequestPath.HOT_VIDEO_LIST_URL)
        Call<List<ResponseEntity>> getHotMediaDatas(@Query("id") int id, @Query("type") int type, @Query("page") int page, @Query("count") int count);
    }
}
