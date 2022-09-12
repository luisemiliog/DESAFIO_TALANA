package com.example.desafiotalana.CORE.LOGIN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.desafiotalana.CORE.LOGIN.MODEL.LoginInteractorImplements;
import com.example.desafiotalana.CORE.LOGIN.PRESENTER.LoginPresenter;
import com.example.desafiotalana.CORE.LOGIN.PRESENTER.LoginPresenterImplements;
import com.example.desafiotalana.CORE.LOGIN.VIEW.LoginView;
import com.example.desafiotalana.CORE.HOME.MainActivity;
import com.example.desafiotalana.R;
import com.google.android.material.textfield.TextInputLayout;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends AppCompatActivity implements LoginView {


    private TextInputLayout userName, userPass;
    private  LoginPresenter loginPresenter;
    private Button buttonLogin;
    private SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.userName = findViewById(R.id.userName);
        this.userName.getEditText().setText("juan@empresa.cl");
        this.userPass = findViewById(R.id.userPass);
        this.userPass.getEditText().setText("mi_password");
        this.loginPresenter = new LoginPresenterImplements(this, new LoginInteractorImplements());
        this.buttonLogin = findViewById(R.id.login_btn);
        this.preferences = getSharedPreferences("Sesion",MODE_PRIVATE);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.ValidateUserAndPass(userName.getEditText().getText().toString().trim(),userPass.getEditText().getText().toString().trim());
            }
        });


    }


    @Override
    public void setUserError() {

        Toast.makeText(this,"Ingrese Usuario Valido",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasError() {
        Toast.makeText(this,"Error de pass",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void toInitActivity() {
        Toast.makeText(this,"Login con exito",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setServerError() {
        Toast.makeText(this,"Error al conectar con servidor",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAuthError() {
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Credenciales Invalidas")
                .setContentText("Ingrese un usuario y contraseña valido")
                .show();

    }

    @Override
    public void setSaveUserSucces() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    @Override
    public void setSaveUserSError() {
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Error al verificar usuario")
                .setContentText("Intente ingresar nuevamente")
                .show();
    }

    @Override
    public void setUserDatabase(String user, String token) {
      loginPresenter.saveUserDatavase(LoginActivity.this, user, token);
    }




}