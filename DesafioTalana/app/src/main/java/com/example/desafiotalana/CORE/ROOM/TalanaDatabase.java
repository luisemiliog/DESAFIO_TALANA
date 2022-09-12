package com.example.desafiotalana.CORE.ROOM;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract  class TalanaDatabase extends RoomDatabase {
    private static final String dbName = "talana";
    private static TalanaDatabase talanaDatabase;
    public static synchronized  TalanaDatabase getTalanaDatabase(Context context){
        if (talanaDatabase == null){
            talanaDatabase = Room.databaseBuilder(context, TalanaDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return talanaDatabase;
    }

    public abstract UserDao userDao();
}
