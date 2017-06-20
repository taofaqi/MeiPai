package com.taofaqi.meipai.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CrazyForUu on 2016/3/11.
 */
public class MainTab {
    /**
     * color : ff7e51
     * has_banner : 0
     * has_content_rank : 0
     * icon : http://mvimg10.meitudata.com/55ef949c90ad58565.png
     * id : 1
     * index : 0
     * name : 热门
     * type : 1
     */
    @SerializedName("color")
    private String color;
    @SerializedName("has_banner")
    private int hasBanner;
    @SerializedName("has_content_rank")
    private int hasContentRank;
    @SerializedName("icon")
    private String icon;
    @SerializedName("id")
    private int id;
    @SerializedName("index")
    private int index;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private int type;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHasBanner() {
        return hasBanner;
    }

    public void setHasBanner(int hasBanner) {
        this.hasBanner = hasBanner;
    }

    public int getHasContentRank() {
        return hasContentRank;
    }

    public void setHasContentRank(int hasContentRank) {
        this.hasContentRank = hasContentRank;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
