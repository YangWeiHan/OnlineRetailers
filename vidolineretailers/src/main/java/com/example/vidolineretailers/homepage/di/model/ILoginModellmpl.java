package com.example.vidolineretailers.homepage.di.model;

import com.example.vidolineretailers.homepage.apils.Apils;
import com.example.vidolineretailers.homepage.di.Contract.ILoginContract;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class ILoginModellmpl implements ILoginContract.ILoginModel {

    @Override
    public void containLoginData(String username, String password, final OnCallBack onCallBack) {
        String urlString = Apils.LOGIN_URL+"?phone="+username+"&pwd="+password;

        OkGo.<String>post(urlString).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                onCallBack.setData(responseData);
            }
        });
    }
}
