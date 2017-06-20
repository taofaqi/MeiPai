package com.taofaqi.meipai.bean;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class ResponseEntity {


    @SerializedName("recommend_caption")
    private String recommendCaption;
    @SerializedName("recommend_cover_pic")
    private String recommendCoverPic;
    @SerializedName("recommend_cover_pic_size")
    private String recommendCoverPicSize;

    @SerializedName("media")
    private MediaEntity media;
    @SerializedName("type")
    private String type;

    public static ResponseEntity objectFromData(String str) {

        return new Gson().fromJson(str, ResponseEntity.class);
    }

    public static List<ResponseEntity> arrayResEntityFromData(String str) {

        Type listType = new TypeToken<ArrayList<ResponseEntity>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public void setRecommendCaption(String recommendCaption) {
        this.recommendCaption = recommendCaption;
    }

    public void setRecommendCoverPic(String recommendCoverPic) {
        this.recommendCoverPic = recommendCoverPic;
    }

    public void setRecommendCoverPicSize(String recommendCoverPicSize) {
        this.recommendCoverPicSize = recommendCoverPicSize;
    }

    public void setMedia(MediaEntity media) {
        this.media = media;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecommendCaption() {
        return recommendCaption;
    }

    public String getRecommendCoverPic() {
        return recommendCoverPic;
    }

    public String getRecommendCoverPicSize() {
        return recommendCoverPicSize;
    }

    public MediaEntity getMedia() {
        return media;
    }

    public String getType() {
        return type;
    }

}
