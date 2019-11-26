package com.example.dixuan_1904.Http;

import com.example.dixuan_1904.repository.entity.RecyclerBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {
    String recyclerUrl="https://www.wanandroid.com/";
    @GET("project/list/1/json")
    Observable<RecyclerBean> getRecyclerData(@QueryMap Map<String,Object> map);

}
