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
public class UserEntity implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("screen_name")
    private String screenName;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("followers_count")
    private int followersCount;
    @SerializedName("friends_count")
    private int friendsCount;
    @SerializedName("reposts_count")
    private int repostsCount;
    @SerializedName("videos_count")
    private int videosCount;
    @SerializedName("real_videos_count")
    private int realVideosCount;
    @SerializedName("photos_count")
    private int photosCount;
    @SerializedName("be_liked_count")
    private int beLikedCount;
    @SerializedName("url")
    private String url;
    @SerializedName("created_at")
    private int createdAt;

    public static UserEntity objectFromData(String str) {

        return new Gson().fromJson(str, UserEntity.class);
    }

    public static List<UserEntity> arrayUserEntityFromData(String str) {

        Type listType = new TypeToken<ArrayList<UserEntity>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public void setVideosCount(int videosCount) {
        this.videosCount = videosCount;
    }

    public void setRealVideosCount(int realVideosCount) {
        this.realVideosCount = realVideosCount;
    }

    public void setPhotosCount(int photosCount) {
        this.photosCount = photosCount;
    }

    public void setBeLikedCount(int beLikedCount) {
        this.beLikedCount = beLikedCount;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public int getVideosCount() {
        return videosCount;
    }

    public int getRealVideosCount() {
        return realVideosCount;
    }

    public int getPhotosCount() {
        return photosCount;
    }

    public int getBeLikedCount() {
        return beLikedCount;
    }

    public String getUrl() {
        return url;
    }

    public int getCreatedAt() {
        return createdAt;
    }
}
