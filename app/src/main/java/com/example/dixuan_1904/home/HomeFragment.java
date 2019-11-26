package com.example.dixuan_1904.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dixuan_1904.Base.BaseView;
import com.example.dixuan_1904.Base.IBaseView;
import com.example.dixuan_1904.R;
import com.example.dixuan_1904.repository.entity.RecyclerAdapter;
import com.example.dixuan_1904.repository.entity.RecyclerBean;
import com.example.dixuan_1904.utils.Logger;

import java.util.List;

public class HomeFragment extends BaseView<HomeContract.HomePresenter> implements HomeContract.HomeView {

    private RecyclerView mRecycler;
    private RecyclerAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getRecyclerList();
        mRecycler = view.findViewById(R.id.recycler);
        initView();
    }

    private void initView() {
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        adapter = new RecyclerAdapter(getActivity());
        mRecycler.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment_contract;
    }

    @Override
    public void onSuccess(RecyclerBean data) {
        Log.i("Text", "onSuccess: ======="+data.toString());
        if (data!=null){
            List<RecyclerBean.DataBean.DatasBean> datas = data.getData().getDatas();
            if (datas!=null){
                adapter.setList(datas);
            }
        }
    }

    @Override
    public void onFail(String str) {
        Toast.makeText(getActivity(), str+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public HomeContract.HomePresenter createPresenter() {
        return new HomePresenter();
    }
}
