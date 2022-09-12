package com.example.desafiotalana.CORE.LOGIN.PRESENTER;

import android.content.Context;
import android.widget.Toast;

import com.bea.xml.stream.samples.AllocEventParser;
import com.example.desafiotalana.CORE.LOGIN.MODEL.LoginInteractor;
import com.example.desafiotalana.CORE.LOGIN.VIEW.LoginView;
import com.example.desafiotalana.CORE.ROOM.UserEntity;

public class LoginPresenterImplements implements LoginPresenter, LoginInteractor.OnLoginListener{
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImplements(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }


    @Override
    public void succes(String user,  String token) {
        loginView.setUserDatabase(user,token);
    }

    @Override
    public void onUserError() {
        loginView.setUserError();
    }

    @Override
    public void onPassError() {
        loginView.setPasError();
    }

    @Override
    public void onServerError() {
        loginView.setServerError();
    }

    @Override
    public void onAuthError() {
        loginView.setAuthError();

    }

    @Override
    public void saveSucces() {
        loginView.setSaveUserSucces();
    }

    @Override
    public void saveError() {
        loginView.setSaveUserSError();

    }

    @Override
    public void ValidateUserAndPass(String user, String Pass) {
        this.loginInteractor.login(user,Pass,this);

    }

    @Override
    public void saveUserDatavase(Context context, String user, String token) {
        this.loginInteractor.saveUserToLogin(context,user,token,this);
    }


    @Override
    public void onDestroy() {
        this.loginView = null;
    }
}
