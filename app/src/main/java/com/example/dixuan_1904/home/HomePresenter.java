package com.example.dixuan_1904.home;

import com.example.dixuan_1904.Base.BasePresenter;
import com.example.dixuan_1904.Base.IBaseCallBack;
import com.example.dixuan_1904.repository.entity.RecyclerBean;
import com.example.dixuan_1904.repository.repository.HomeRepository;

public class HomePresenter extends BasePresenter<HomeContract.HomeView> implements HomeContract.HomePresenter {
    private HomeContract.HomeRepository homeRepository;
    public HomePresenter(){
        homeRepository = new HomeRepository();
    }
    @Override
    public void getRecyclerList() {
        homeRepository.getRecyclerList(new IBaseCallBack<RecyclerBean>() {
            @Override
            public void onSuccess(RecyclerBean data) {
                if (mView!=null){
                    mView.onSuccess(data);

                }
            }

            @Override
            public void onFail(String str) {
                if (mView!=null){
                    mView.onFail(str);
                }
            }
        });
    }
}
