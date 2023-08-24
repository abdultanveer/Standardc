package com.example.standard;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase{
    private static final String LOG_TAG = AppDatabase.class.getSimpleName();

    public abstract PersonDao personDao();

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "personlist";
    private static AppDatabase sInstance;

    //instance it might be about singleton design pattern
    public static AppDatabase getInstance(Context context) {
        sInstance = Room.databaseBuilder(context,
                AppDatabase.class,
                DATABASE_NAME).build();
        return sInstance;
    }


}