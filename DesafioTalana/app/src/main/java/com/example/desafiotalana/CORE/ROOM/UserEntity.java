package com.example.desafiotalana.CORE.ROOM;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name="userName")
    String userName;
    @ColumnInfo(name="token")
    String token;
    @ColumnInfo(name="sesion")
    Boolean sesion;

    public Boolean getSesion() {
        return sesion;
    }

    public void setSesion(Boolean sesion) {
        this.sesion = sesion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }



    public void setToken(String token) {
        this.token = token;
    }
}
