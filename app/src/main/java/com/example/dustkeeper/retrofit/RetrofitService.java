package com.example.dustkeeper.retrofit;

import com.example.dustkeeper.BuildConfig;
import com.example.dustkeeper.retrofit.model.GetPolutionResponse;
import com.example.dustkeeper.retrofit.model.GetPolutionRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("getMsrstnAcctoRltmMesureDnsty?"+
            "serviceKey="+ BuildConfig.polution_key+
            "&returnType=json" +
            "&dataTerm=DAILY" +
            "&ver=1.3")
    Call<GetPolutionResponse> getPolution(
            @Query("stationName") String stationName);
}
