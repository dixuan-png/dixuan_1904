package com.example.dixuan_1904.Base;

public interface IBaseView<P extends IBasePresenter> {

    P createPresenter();

}
