package com.example.vidolineretailers.homepage.di.presenter;

import com.example.vidolineretailers.homepage.di.Contract.ILRContract;
import com.example.vidolineretailers.homepage.di.model.ILRCModellmpl;

import java.lang.ref.SoftReference;

public class ILRPresenterlmpl implements ILRContract.ILRPresenter<ILRContract.ILRView> {
    ILRContract.ILRView ilrView;
    private SoftReference<ILRContract.ILRView> reference;
    private ILRContract.ILRModel modellmpl;

    @Override
    public void attahView(ILRContract.ILRView ilrView) {
        this.ilrView = ilrView;
        reference = new SoftReference<>(ilrView);
        modellmpl = new ILRCModellmpl();
    }

    @Override
    public void decathView(ILRContract.ILRView ilrView) {
        reference.clear();
    }

    @Override
    public void ruquestRegisterData(String username, String password) {
        modellmpl.containRegisterData(username, password, new ILRContract.ILRModel.OnCallBack() {
            @Override
            public void setData(String responseData) {
                ilrView.setRegisterData(responseData);
            }
        });
    }


}
