package com.example.dixuan_1904.Base;

public interface IBasePresenter<V extends IBaseView> {
    void attachView(V view);
    void detachView();
}
