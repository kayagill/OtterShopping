package com.example.ottershopping;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

    @Database(entities = {User.class}, version = 1)
    public abstract class AppDataBase extends RoomDatabase {
        public static final String USER_TABLE = "user_log";
        private static volatile AppDataBase instance;
        private static final Object LOCK = new Object();
        public abstract OtterDao otterDao();
        public static AppDataBase getInstance(Context context)
        {
            if(instance == null){
                synchronized(LOCK){
                    if(instance == null){
                        instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,USER_TABLE).build();
                    }
                }
            }
            return instance;
        }
    }


