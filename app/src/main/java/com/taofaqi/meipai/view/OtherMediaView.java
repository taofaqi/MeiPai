package com.taofaqi.meipai.view;

import com.taofaqi.meipai.bean.ResponseEntity;

import java.util.List;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public interface OtherMediaView {
    void showOtherMeidaDatas(List<ResponseEntity> otherEntities);
    void showErrorMsg();
}
