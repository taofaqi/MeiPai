package com.taofaqi.meipai.view;

import com.taofaqi.meipai.bean.ResponseEntity;

import java.util.List;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public interface HotMediaView {
    void showHotMedia(List<ResponseEntity> hotEntities);
    void showErrorMsg();
}
