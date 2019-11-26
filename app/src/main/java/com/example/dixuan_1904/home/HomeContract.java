package com.example.dixuan_1904.home;

import com.example.dixuan_1904.Base.IBaseCallBack;
import com.example.dixuan_1904.Base.IBasePresenter;
import com.example.dixuan_1904.Base.IBaseView;
import com.example.dixuan_1904.repository.entity.RecyclerBean;

public interface HomeContract {
    public interface HomeView extends IBaseView<HomePresenter>{
        void onSuccess(RecyclerBean data);
        void onFail(String str);
    }
    public interface HomePresenter extends IBasePresenter<HomeView>{
        void getRecyclerList();
    }
    public interface HomeRepository{
        void getRecyclerList(IBaseCallBack<RecyclerBean> callBack);
    }
}
