package com.example.desafiotalana.CORE.LOGIN.MODEL;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.desafiotalana.CORE.LOGIN.VIEW.LoginView;
import com.example.desafiotalana.CORE.ROOM.TalanaDatabase;
import com.example.desafiotalana.CORE.ROOM.UserDao;
import com.example.desafiotalana.CORE.ROOM.UserEntity;
import com.example.desafiotalana.IO.ApiRestAdapter;
import com.example.desafiotalana.IO.ApiRestInterface;
import com.example.desafiotalana.IO.RESPONSES.LoginResponse;
import com.example.desafiotalana.Utils;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginInteractorImplements implements LoginInteractor   {


    @Override
    public void login(String user, String pass, OnLoginListener listener) {
        if (TextUtils.isEmpty(user)){
            listener.onUserError();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            listener.onPassError();
            return;
        }
        JsonObject json = new JsonObject();
        json.addProperty("username", user);
        json.addProperty("password", pass);
        Call<LoginResponse> call;
        call = ApiRestAdapter.getRestApiService().loginUser(json);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.code()==200){
                    if (response.body().getStatus().equals("OK")){

                        listener.succes(user, response.body().getToken().trim());

                    }else {
                        listener.onAuthError();
                    }

                }else {
                    listener.onAuthError();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                listener.onServerError();
            }
        });

    }

    @Override
    public void saveUserToLogin(Context context, String user, String token,OnLoginListener listener) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(user);
        userEntity.setToken(token);
        userEntity.setSesion(true);
        if(Utils.validateInput(userEntity)){
            TalanaDatabase talanaDatabase = TalanaDatabase.getTalanaDatabase(context);
            final UserDao userDao = talanaDatabase.userDao();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if(userDao.getUser(user)!=null){
                        userDao.updateToken(user,token);
                        Utils.setSesion(context,true);
                        listener.saveSucces();
                    }else
                    {
                        userDao.registerUser(userEntity);
                        Utils.setSesion(context,true);
                        listener.saveSucces();
                    }
                }
            }).start();

        }else{
            listener.saveError();
        }
    }
}
