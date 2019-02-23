package com.tae.a101newjwtlogin;


import android.app.Activity;
import android.app.Application;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tae.a101newjwtlogin.dao.PetDatabase;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {
//    public static SharedPreferences sharedPreferences;
//  замещается даггером

    private static Context context;
    private static PetDatabase petDatabase;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
     //   sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        context = this;
        petDatabase = Room.databaseBuilder(this, PetDatabase.class, "pet-db").allowMainThreadQueries().build();
       initDagger();
    }

    public static PetDatabase getPetDatabase() {
        return petDatabase;
    }

    public static Context getContext() {
        return context;
    }

//    public static SharedPreferences getSharedPreferences() {
//        return sharedPreferences;
//    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    private void initDagger(){
        DaggerAppComponent.builder().application(this).build().inject(this);
    }
}
