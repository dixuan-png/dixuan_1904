package com.example.dixuan_1904.Base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseView<P extends IBasePresenter> extends Fragment implements IBaseView<P> {
   protected P mPresenter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mPresenter = createPresenter();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(getLayoutId(),container,false);
        return view;

    }
    public boolean isAddBackStack(){
        return true;
    }
    public Action getAction(){
        return Action.Hide;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
    protected abstract int getLayoutId();
    public enum Action{
        Remove,Detach,Hide
    }
}
