package com.example.vidolineretailers.homepage.di.presenter;

import com.example.vidolineretailers.homepage.di.Contract.ILoginContract;
import com.example.vidolineretailers.homepage.di.model.ILoginModellmpl;

import java.lang.ref.SoftReference;

public class ILoginPresenter implements ILoginContract.ILRPresenter<ILoginContract.ILoginView> {
    ILoginContract.ILoginView iLoginView;
    private SoftReference<ILoginContract.ILoginView> reference;
    private ILoginModellmpl modellmpl;

    @Override
    public void attahView(ILoginContract.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        reference = new SoftReference<>(iLoginView);
        modellmpl = new ILoginModellmpl();

    }

    @Override
    public void decathView(ILoginContract.ILoginView iLoginView) {
        reference.clear();

    }

    @Override
    public void ruquestRegisterData(String username, String password) {
        modellmpl.containLoginData(username, password, new ILoginContract.ILoginModel.OnCallBack() {
            @Override
            public void setData(String responseData) {
                iLoginView.setLoginData(responseData);
            }
        });
    }
}
