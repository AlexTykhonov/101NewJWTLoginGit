package com.tae.a101newjwtlogin.di.module;

import android.content.Context;

import com.tae.a101newjwtlogin.di.qualifier.ActivityContext;
import com.tae.a101newjwtlogin.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityContextModule {
    Context context;

    public ActivityContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context getContext () {
        return this.context;
    }
}
