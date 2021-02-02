package com.codetalenta.batikindonesia;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BatikService {
    @GET("popular")
    Call<ResponseBody> getPopular();

    @GET("all")
    Call<ResponseBody> getAll();
}
