package com.example.dixuan_1904.Base;

public interface IBaseCallBack<C> {
    void onSuccess(C data);
    void onFail(String str);
}
