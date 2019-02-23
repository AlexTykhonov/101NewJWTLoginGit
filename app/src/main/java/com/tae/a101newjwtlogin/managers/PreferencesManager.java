package com.tae.a101newjwtlogin.managers;

import android.content.SharedPreferences;
import com.tae.a101newjwtlogin.App;

import javax.inject.Inject;

public class PreferencesManager {
    private SharedPreferences sharedPreferences;

    public PreferencesManager(SharedPreferences sharedPreferences) {
       // sharedPreferences = App.getSharedPreferences();
        this.sharedPreferences = sharedPreferences;
    }

    public void setAuthToken(String token) {
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString("token",token);
        prefEditor.apply();
    }

    public String getAuthToken(){
        return sharedPreferences.getString("token","null");
    }
}
