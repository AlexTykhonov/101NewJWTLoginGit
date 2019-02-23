package com.tae.a101newjwtlogin.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Pet.class}, version = 1, exportSchema = false)
public abstract class PetDatabase extends RoomDatabase {

    public abstract PetDao petDao();
}