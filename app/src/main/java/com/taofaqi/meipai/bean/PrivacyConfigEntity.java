package com.taofaqi.meipai.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public class PrivacyConfigEntity implements Serializable{
    @SerializedName("allow_save_medias")
    private int allowSaveMedias;

    public static PrivacyConfigEntity objectFromData(String str) {

        return new Gson().fromJson(str, PrivacyConfigEntity.class);
    }

    public static List<PrivacyConfigEntity> arrayPrivacyConfigEntityFromData(String str) {

        Type listType = new TypeToken<ArrayList<PrivacyConfigEntity>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public void setAllowSaveMedias(int allowSaveMedias) {
        this.allowSaveMedias = allowSaveMedias;
    }

    public int getAllowSaveMedias() {
        return allowSaveMedias;
    }
}
