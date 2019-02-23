package com.tae.a101newjwtlogin.di.module;

import com.tae.a101newjwtlogin.MainActivity;
import com.tae.a101newjwtlogin.PetActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract PetActivity contributePetActivity();
}
