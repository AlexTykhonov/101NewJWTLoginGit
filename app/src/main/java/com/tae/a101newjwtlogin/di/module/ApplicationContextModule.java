package com.tae.a101newjwtlogin.di.module;

import android.app.Activity;
import android.content.Context;

import com.tae.a101newjwtlogin.di.qualifier.ActivityContext;
import com.tae.a101newjwtlogin.di.qualifier.ApplicationContext;
import com.tae.a101newjwtlogin.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {

    private Context context;

    public ApplicationContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context getContext () {
        return this.context;
    }
}
