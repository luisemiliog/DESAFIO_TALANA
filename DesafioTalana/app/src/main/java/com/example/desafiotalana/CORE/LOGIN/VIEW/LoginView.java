package com.example.desafiotalana.CORE.LOGIN.VIEW;

public interface LoginView {
    void setUserError();
    void setPasError();
    void toInitActivity();
    void setServerError();
    void setAuthError();
    void setSaveUserSucces();
    void setSaveUserSError();
    void setUserDatabase(String user, String token);
}
