package com.example.vidolineretailers.homepage.ui.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vidolineretailers.R;
import com.example.vidolineretailers.homepage.data.bean.RegisterBean;
import com.example.vidolineretailers.homepage.di.Contract.ILRContract;
import com.example.vidolineretailers.homepage.di.presenter.ILRPresenterlmpl;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements ILRContract.ILRView {


    @BindView(R.id.icon_phone)
    ImageView iconPhone;
    @BindView(R.id.edit_phone_register)
    EditText editPhoneRegister;
    @BindView(R.id.lineone)
    TextView lineone;
    @BindView(R.id.icon_Verification)
    ImageView iconVerification;
    @BindView(R.id.edit_VerificationCode)
    EditText editVerificationCode;
    @BindView(R.id.re_VerificationCode)
    TextView reVerificationCode;
    @BindView(R.id.linetwo)
    TextView linetwo;
    @BindView(R.id.icon_lock)
    ImageView iconLock;
    @BindView(R.id.edit_pass_register)
    EditText editPassRegister;
    @BindView(R.id.icon_eye)
    ImageView iconEye;
    @BindView(R.id.linethree)
    TextView linethree;
    @BindView(R.id.back_loginpager)
    TextView backLoginpager;
    @BindView(R.id.button_register)
    Button buttonRegister;
    private ILRPresenterlmpl presenterlmpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        presenterlmpl = new ILRPresenterlmpl();

        presenterlmpl.attahView(this);



    }


    @OnClick({R.id.back_loginpager, R.id.button_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_loginpager:
                break;
            case R.id.button_register:
                String username = editPhoneRegister.getText().toString();
                String password = editPassRegister.getText().toString();
                presenterlmpl.ruquestRegisterData(username,password);
                break;
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenterlmpl.decathView(this);
    }

    @Override
    public void setRegisterData(String responseData) {
        Gson gson = new Gson();
        RegisterBean registerBean = gson.fromJson(responseData, RegisterBean.class);
        if ( registerBean.getMessage().equals("注册成功")){
            Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
        }else if (registerBean.getMessage().equals("该手机号已注册，不能重复注册！")){
            Toast.makeText(this,"该手机号已注册，不能重复注册！",Toast.LENGTH_LONG).show();
        }
    }
}
