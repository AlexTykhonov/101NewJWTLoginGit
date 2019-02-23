package com.tae.a101newjwtlogin.di.component;

import android.app.Application;

import com.tae.a101newjwtlogin.App;
import com.tae.a101newjwtlogin.di.module.ActivityContextModule;
import com.tae.a101newjwtlogin.di.module.ActivityModule;
import com.tae.a101newjwtlogin.di.module.ApplicationContextModule;
import com.tae.a101newjwtlogin.di.module.SharedPreferenceModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules={AndroidSupportInjectionModule.class, ActivityContextModule.class,ActivityModule.class,
        ApplicationContextModule.class,SharedPreferenceModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);
}