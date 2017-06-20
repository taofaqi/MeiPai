package com.taofaqi.meipai.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.taofaqi.meipai.BaseApp;
import com.taofaqi.meipai.R;
import com.taofaqi.meipai.bean.MediaEntity;
import com.taofaqi.meipai.bean.ResponseEntity;
import com.taofaqi.meipai.presenter.HotMediaPresenter;
import com.taofaqi.meipai.presenter.impl.HotMediaPresenterImpl;
import com.taofaqi.meipai.ui.activities.DetailActivity;
import com.taofaqi.meipai.ui.adapter.HotMediaAdapter;
import com.taofaqi.meipai.view.HotMediaView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment implements HotMediaView,SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.hot_fragment_rv)
    RecyclerView hotFragmentRv;
    @Bind(R.id.hot_fragment_swipeRefreshLayout)
    SwipeRefreshLayout hotFragmentSwipeRefreshLayout;
    private HotMediaAdapter hotMediaAdapter;
    private HotMediaPresenter hotMediaPresenter;
    private boolean isRefreshing;
    private int PARAMS_PAGE;
    public HotFragment() {
    }

    public static HotFragment newInstance() {
        Bundle args = new Bundle();
        HotFragment fragment = new HotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hotFragmentSwipeRefreshLayout.setOnRefreshListener(this);
        initDatas();
    }

    private void initDatas() {
        hotMediaPresenter = new HotMediaPresenterImpl(this);
        hotMediaPresenter.loadHotMediaDatas(++PARAMS_PAGE);

        hotFragmentRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isRefreshing){
                    //获取RecyclerView最后一个子项的
                    View childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                    int position = recyclerView.getChildAdapterPosition(childAt);
                    if (hotMediaAdapter.getItemCount() - position < 5){
                        isRefreshing = true;
                        hotMediaPresenter.loadHotMediaDatas(++PARAMS_PAGE);
                    }
                }
            }
        });

        isRefreshing = false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void showHotMedia(List<ResponseEntity> hotEntities) {
        hotFragmentSwipeRefreshLayout.setRefreshing(false);  //设置刷新为false
        hotMediaAdapter = new HotMediaAdapter((ArrayList<ResponseEntity>) hotEntities);

//        int spacingInPixels = 8;
        hotFragmentRv.setHasFixedSize(true);
//        hotFragmentRv.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        hotFragmentRv.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));//实现RecyclerView的两列效果

        hotFragmentRv.setAdapter(hotMediaAdapter);
        isRefreshing = false;


        hotMediaAdapter.setOnRecyclerViewItemListener(new HotMediaAdapter.OnRecyclerViewItemListener() {
            @Override
            public void setOnItemClickListener(int position, MediaEntity mediaEntity) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("media",mediaEntity);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showErrorMsg() {
        Toast.makeText(BaseApp.getContext(), "数据加载失败", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRefresh() {
        hotFragmentSwipeRefreshLayout.setRefreshing(true);  //设置刷新为true
        PARAMS_PAGE = 1;   //下拉刷新后需要把page设置为1
        hotMediaPresenter.loadHotMediaDatas(++PARAMS_PAGE);
        isRefreshing = true;
    }
}
