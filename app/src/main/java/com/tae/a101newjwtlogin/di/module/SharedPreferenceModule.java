package com.tae.a101newjwtlogin.di.module;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tae.a101newjwtlogin.di.qualifier.ApplicationContext;
import com.tae.a101newjwtlogin.di.scope.ActivityScope;
import com.tae.a101newjwtlogin.di.scope.ApplicationScope;
import com.tae.a101newjwtlogin.managers.PreferencesManager;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferenceModule {

SharedPreferences sharedPreferences;

    @Provides
    @ActivityScope
    public SharedPreferences getSharedPreferences (Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    @Provides
    @ActivityScope
    public PreferencesManager getPreferenceManager(SharedPreferences sharedPreferences) {
        return new PreferencesManager(sharedPreferences);
    }
}
////test