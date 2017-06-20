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
public class MediaEntity implements Serializable{
    
    @SerializedName("id")
    private int id;
    @SerializedName("video")
    private String video;
    @SerializedName("url")
    private String url;
    @SerializedName("cover_pic")
    private String coverPic;
    @SerializedName("pic_size")
    private String picSize;
    @SerializedName("category")
    private int category;
    @SerializedName("time")
    private int time;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("comments_count")
    private int commentsCount;
    @SerializedName("likes_count")
    private int likesCount;
    @SerializedName("reposts_count")
    private int repostsCount;

    @SerializedName("user")
    private UserEntity user;
    @SerializedName("feed_id")
    private long feedId;
    /**
     * allow_save_medias : 0
     */

    @SerializedName("privacy_config")
    private PrivacyConfigEntity privacyConfig;
    @SerializedName("has_watermark")
    private int hasWatermark;
    @SerializedName("display_source")
    private int displaySource;

    public static MediaEntity objectFromData(String str) {

        return new Gson().fromJson(str, MediaEntity.class);
    }

    public static List<MediaEntity> arrayMediaEntityFromData(String str) {

        Type listType = new TypeToken<ArrayList<MediaEntity>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public void setPicSize(String picSize) {
        this.picSize = picSize;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setFeedId(long feedId) {
        this.feedId = feedId;
    }

    public void setPrivacyConfig(PrivacyConfigEntity privacyConfig) {
        this.privacyConfig = privacyConfig;
    }

    public void setHasWatermark(int hasWatermark) {
        this.hasWatermark = hasWatermark;
    }

    public void setDisplaySource(int displaySource) {
        this.displaySource = displaySource;
    }

    public int getId() {
        return id;
    }

    public String getVideo() {
        return video;
    }

    public String getUrl() {
        return url;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public String getPicSize() {
        return picSize;
    }

    public int getCategory() {
        return category;
    }

    public int getTime() {
        return time;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public UserEntity getUser() {
        return user;
    }

    public long getFeedId() {
        return feedId;
    }

    public PrivacyConfigEntity getPrivacyConfig() {
        return privacyConfig;
    }

    public int getHasWatermark() {
        return hasWatermark;
    }

    public int getDisplaySource() {
        return displaySource;
    }

}
