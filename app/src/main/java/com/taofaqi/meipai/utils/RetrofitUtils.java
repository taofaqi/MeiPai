package com.taofaqi.meipai.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public class RetrofitUtils {
    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(AppConstants.RequestPath.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
