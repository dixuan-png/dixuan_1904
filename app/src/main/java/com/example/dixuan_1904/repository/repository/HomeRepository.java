package com.example.dixuan_1904.repository.repository;

import com.example.dixuan_1904.Base.IBaseCallBack;
import com.example.dixuan_1904.Http.ApiService;
import com.example.dixuan_1904.home.HomeContract;
import com.example.dixuan_1904.repository.entity.RecyclerBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeRepository implements HomeContract.HomeRepository {
    @Override
    public void getRecyclerList(final IBaseCallBack<RecyclerBean> callBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.recyclerUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Map<String,Object> map = new HashMap();
        map.put("cid",294);
        Observable<RecyclerBean> observable = apiService.getRecyclerData(map);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecyclerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecyclerBean recyclerBean) {
                        if (recyclerBean!=null){
                            callBack.onSuccess(recyclerBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
