package com.example.vidolineretailers.homepage.di.model;

import com.example.vidolineretailers.homepage.apils.Apils;
import com.example.vidolineretailers.homepage.di.Contract.ILRContract;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class ILRCModellmpl implements ILRContract.ILRModel {

    @Override
    public void containRegisterData(String username, String password, final OnCallBack onCallBack) {
        String urlString = Apils.REGIDTER_URL+"?phone="+username+"&pwd="+password;

        OkGo.<String>post(urlString).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                onCallBack.setData(responseData);
            }
        });

    }
}
