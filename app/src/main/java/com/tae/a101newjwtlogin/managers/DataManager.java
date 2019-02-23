package com.tae.a101newjwtlogin.managers;

import android.content.Context;


import com.tae.a101newjwtlogin.App;
import com.tae.a101newjwtlogin.api.Api;
import com.tae.a101newjwtlogin.controller.Controller;
import com.tae.a101newjwtlogin.dao.PetDatabase;

import javax.inject.Inject;

public class DataManager {
    private static DataManager INSTANCE = null;

    private Context mContext;

    @Inject
     PreferencesManager mPreferencesManager;

    private Api api;
    private PetDatabase petDatabase;

    public DataManager() {
        mContext = App.getContext();
      //  mPreferencesManager = new PreferencesManager();
        api = Controller.createService(Api.class);
        petDatabase = App.getPetDatabase();
    }

    public Api getApi() {
        return api;
    }

    public static DataManager getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

  //  public PreferencesManager getPreferencesManager() {
  //      return mPreferencesManager;
  //  }

    public Context getContext() {
        return mContext;
    }

    public PetDatabase getDatabase() {
        return petDatabase;
    }
}
