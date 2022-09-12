package com.example.desafiotalana.CORE.LOGIN.MODEL;

import android.content.Context;

public interface LoginInteractor {

    interface OnLoginListener{
        void succes(String user,  String token);
        void onUserError();
        void onPassError();
        void onServerError();
        void onAuthError();
        void saveSucces();
        void saveError();

    }

    void login(String user, String pass, OnLoginListener listener);
    void saveUserToLogin(Context context, String user, String token,OnLoginListener listener);
}
