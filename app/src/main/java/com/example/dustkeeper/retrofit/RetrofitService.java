package com.example.dustkeeper.retrofit;

import com.example.dustkeeper.retrofit.model.GetPolutionResponse;
import com.example.dustkeeper.retrofit.model.GetPolutionRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("B552584/ArpltnInforInqireSvc/{path}")
    Call<GetPolutionResponse> getPolution( @Path("path") GetPolutionRequest request);
}
