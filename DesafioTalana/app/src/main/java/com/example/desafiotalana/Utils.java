package com.example.desafiotalana;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.desafiotalana.CORE.ROOM.UserEntity;

public class Utils {

    private static  SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public static Boolean validateInput(UserEntity userEntity){
        if(userEntity.getUserName().isEmpty() || userEntity.getToken().isEmpty())
            return false;
        return true;
    }

  public static void  setSesion(Context context ,Boolean aBoolean){
        preferences = context.getSharedPreferences("sesion",Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putBoolean("userSesion",aBoolean);
        editor.commit();
  }
    public static Boolean getSesion(Context context){
        preferences = context.getSharedPreferences("sesion",Context.MODE_PRIVATE);
        return preferences.getBoolean("userSesion",false);
    }
}
