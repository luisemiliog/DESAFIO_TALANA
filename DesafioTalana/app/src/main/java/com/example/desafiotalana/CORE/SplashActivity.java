package com.example.desafiotalana.CORE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.desafiotalana.CORE.LOGIN.LoginActivity;
import com.example.desafiotalana.CORE.HOME.MainActivity;
import com.example.desafiotalana.R;
import com.example.desafiotalana.Utils;

public class SplashActivity extends AppCompatActivity {
    private final int DURACION_SPLASH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isLogin()){
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();

                }else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
            }
        }, DURACION_SPLASH);
    }
    private Boolean isLogin(){
        //Toast.makeText(this, "login"+Usuario.isLogin(),Toast.LENGTH_LONG).show();
       return Utils.getSesion(this);
    }
}