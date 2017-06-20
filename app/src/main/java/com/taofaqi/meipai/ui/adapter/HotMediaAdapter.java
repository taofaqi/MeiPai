package com.taofaqi.meipai.ui.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.taofaqi.meipai.BaseApp;
import com.taofaqi.meipai.R;
import com.taofaqi.meipai.bean.MediaEntity;
import com.taofaqi.meipai.bean.ResponseEntity;

import java.util.ArrayList;

/**
 * Created by CrazyForUu on 2016/3/11.
 */
public class HotMediaAdapter extends RecyclerView.Adapter<HotMediaAdapter.HotViewHolder>{

    private ArrayList<ResponseEntity> responseEntities;

    public HotMediaAdapter(ArrayList<ResponseEntity> responseEntities) {
        this.responseEntities = responseEntities;
    }

    @Override
    public HotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(BaseApp.getContext()).inflate(R.layout.list_meida_item, parent, false);
        return new HotViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(HotViewHolder holder, final int position) {
        ResponseEntity hotEntity = responseEntities.get(position);
        String type = hotEntity.getType();
        if (type.equals("media")){
            final MediaEntity media = hotEntity.getMedia();
            holder.listMainSimpleImg.setImageURI(Uri.parse(hotEntity.getRecommendCoverPic()));

            //对子项设置监听事件
            holder.listMainSimpleImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onRecyclerViewItemListener != null){
                        onRecyclerViewItemListener.setOnItemClickListener(position,media);  //将Media实体类传递出去
                    }
                }
            });

            if (!TextUtils.isEmpty(media.getUser().getAvatar())) {
                holder.listMainUserPic.setImageURI(Uri.parse(media.getUser().getAvatar()));
            }
            holder.listMainLikeCount.setText(media.getLikesCount() + "");
            holder.listMainUsername.setText(hotEntity.getRecommendCaption());
        }
    }

    @Override
    public int getItemCount() {
        return responseEntities != null ? responseEntities.size() : 0;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class HotViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView listMainSimpleImg;
        TextView listMainUsername;
        SimpleDraweeView listMainUserPic;
        TextView listMainLikeCount;

        public HotViewHolder(View itemView) {
            super(itemView);
            listMainSimpleImg = (SimpleDraweeView) itemView.findViewById(R.id.list_main_simpleImg);
            listMainUsername = (TextView) itemView.findViewById(R.id.list_main_username);
            listMainUserPic = (SimpleDraweeView) itemView.findViewById(R.id.list_main_userPic);
            listMainLikeCount = (TextView) itemView.findViewById(R.id.list_main_likeCount);
        }
    }

    //内部的接口回调方法
    public interface OnRecyclerViewItemListener{
        void setOnItemClickListener(int position, MediaEntity mediaEntity);
    }
    //初始化
    public OnRecyclerViewItemListener onRecyclerViewItemListener;
    //监听方法
    public void setOnRecyclerViewItemListener(OnRecyclerViewItemListener onRecyclerViewItemListener) {
        this.onRecyclerViewItemListener = onRecyclerViewItemListener;
    }
}
