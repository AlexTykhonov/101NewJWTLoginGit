package com.tae.a101newjwtlogin.api;


import com.tae.a101newjwtlogin.dao.Login;
import com.tae.a101newjwtlogin.dao.Pet;

import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {


    @POST("auth")
    Call<ResponseBody> login(@Body Login login);

    @GET("api")
    Call<List<Pet>> petList();
}
