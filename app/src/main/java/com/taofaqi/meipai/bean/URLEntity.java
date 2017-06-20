package com.taofaqi.meipai.bean;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public class URLEntity {
    private int id;
    private int type;

    public URLEntity(int id, int type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
