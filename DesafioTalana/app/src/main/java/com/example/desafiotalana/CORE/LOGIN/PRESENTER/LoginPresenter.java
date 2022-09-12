package com.example.desafiotalana.CORE.LOGIN.PRESENTER;

import android.content.Context;

public interface LoginPresenter {
    void ValidateUserAndPass(String user, String Pass);
    void saveUserDatavase(Context context,String user, String token);
    void onDestroy();
}
