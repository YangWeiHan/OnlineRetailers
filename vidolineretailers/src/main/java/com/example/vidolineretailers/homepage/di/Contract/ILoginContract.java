package com.example.vidolineretailers.homepage.di.Contract;

public interface ILoginContract {
    public interface ILoginView{

        void setLoginData(String responseData);



    }
    public interface ILRPresenter<ILoginView>{

        void attahView(ILoginView iLoginView);

        void decathView(ILoginView iLoginView);

        void ruquestRegisterData(String username, String password);



    }
    public interface ILoginModel{

        void containLoginData(String username, String password,OnCallBack onCallBack);



        public interface OnCallBack{
            void setData(String responseData);
        }
    }
}
