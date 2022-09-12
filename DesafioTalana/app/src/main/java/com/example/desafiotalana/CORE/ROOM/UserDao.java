package com.example.desafiotalana.CORE.ROOM;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void registerUser(UserEntity user);
    @Query("SELECT * from users where userName=(:userName)")
    UserEntity getUser(String userName);
    @Query("UPDATE  users SET token = (:newToken) where userName=(:userName)")
    void updateToken(String userName, String newToken);
    @Query("SELECT EXISTS (SELECT * from users where sesion=1)")
    Boolean isLogin();


}
