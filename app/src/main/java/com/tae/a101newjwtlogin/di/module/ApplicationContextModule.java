package com.tae.a101newjwtlogin.di.module;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.tae.a101newjwtlogin.App;
import com.tae.a101newjwtlogin.di.qualifier.ActivityContext;
import com.tae.a101newjwtlogin.di.qualifier.ApplicationContext;
import com.tae.a101newjwtlogin.di.scope.ApplicationScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {

    private Context context;

    public ApplicationContextModule(Application application) {
        this.context = application;
    }


    @Provides
    @ApplicationScope

    public Context getContext () {
        return this.context;
    }
}
