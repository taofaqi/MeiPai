package com.taofaqi.meipai.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.taofaqi.meipai.BaseApp;
import com.taofaqi.meipai.R;
import com.taofaqi.meipai.bean.MediaEntity;
import com.taofaqi.meipai.bean.ResponseEntity;
import com.taofaqi.meipai.bean.URLEntity;
import com.taofaqi.meipai.presenter.OtherMediaPresenter;
import com.taofaqi.meipai.presenter.impl.OtherMediaPresenterImpl;
import com.taofaqi.meipai.ui.activities.DetailActivity;
import com.taofaqi.meipai.ui.adapter.HotMediaAdapter;
import com.taofaqi.meipai.utils.SpacesItemDecoration;
import com.taofaqi.meipai.view.OtherMediaView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment implements OtherMediaView {

    @Bind(R.id.other_fragment_recycler)
    RecyclerView otherFragmentRecycler;
    private HotMediaAdapter hotMediaAdapter;
    private OtherMediaPresenter otherMediaPresenter;
    private static int PARAMS_ID;
    private static int PARAMS_TYPE;
    private static int PARAMS_PAGE = 1;

    public OtherFragment() {
        // Required empty public constructor
    }

    public static OtherFragment newInstance(URLEntity urlEntity) {
        Bundle args = new Bundle();

        args.putInt("id", urlEntity.getId());
        args.putInt("type", urlEntity.getType());
        OtherFragment fragment = new OtherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            PARAMS_ID = getArguments().getInt("id", 13);
            PARAMS_TYPE = getArguments().getInt("type", 2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_other, container, false);
        ButterKnife.bind(this, view);
        initDatas();
        return view;
    }

    private void initDatas() {
        otherMediaPresenter = new OtherMediaPresenterImpl(this);
        otherMediaPresenter.loadOtherMediaDatas(PARAMS_ID, PARAMS_TYPE, PARAMS_PAGE);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void showOtherMeidaDatas(List<ResponseEntity> otherEntities) {
        hotMediaAdapter = new HotMediaAdapter((ArrayList<ResponseEntity>) otherEntities);

        int spacingInPixels = 8;

        otherFragmentRecycler.setHasFixedSize(true);
        otherFragmentRecycler.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        otherFragmentRecycler.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2, LinearLayoutManager.VERTICAL,false));//实现RecyclerView的两列效果

        otherFragmentRecycler.setAdapter(hotMediaAdapter);

        hotMediaAdapter.setOnRecyclerViewItemListener(new HotMediaAdapter.OnRecyclerViewItemListener() {
            @Override
            public void setOnItemClickListener(int position,MediaEntity mediaEntity) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("media",mediaEntity);
                intent.putExtras(bundle);
                startActivity(intent);

                Toast.makeText(getContext(), "djdhajd a ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showErrorMsg() {
        Toast.makeText(BaseApp.getContext(), "其他视频网络加载失败", Toast.LENGTH_SHORT).show();
    }
}