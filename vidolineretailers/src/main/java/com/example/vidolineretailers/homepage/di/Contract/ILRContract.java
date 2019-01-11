package com.example.vidolineretailers.homepage.di.Contract;

public interface ILRContract {

    public interface ILRView{

        void setRegisterData(String responseData);



    }

    public interface ILRPresenter<ILRView>{

        void attahView(ILRView ilrView);

        void decathView(ILRView ilrView);

        void ruquestRegisterData(String username,String password);



    }

    public interface ILRModel{

        void containRegisterData(String username,String password,OnCallBack onCallBack);



        public interface OnCallBack{
            void setData(String responseData);
        }
    }
}
