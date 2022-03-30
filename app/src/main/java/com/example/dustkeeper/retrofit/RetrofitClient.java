package com.example.dustkeeper.retrofit;

import com.example.dustkeeper.retrofit.model.ErrorResponse;
import com.example.dustkeeper.retrofit.model.GetPolutionResponse;
import com.example.dustkeeper.retrofit.model.GetPolutionRequest;
import com.example.dustkeeper.retrofit.model.MyResponse;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient{
    public static Retrofit retrofit;
    public static RetrofitService retrofitService;

    //싱글톤으로 생성
    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://apis.data.go.kr/")
                    .build();
        }
        return retrofit;
    }

    public static RetrofitService getRetrofitService(){
        if(retrofitService == null){
            retrofitService = getRetrofit().create(RetrofitService.class);
        }
        return retrofitService;
    }

    public static ErrorResponse getErrorResponse(ResponseBody responsebody) throws IOException {
        Converter<ResponseBody, ErrorResponse> errorConverter = getRetrofit().responseBodyConverter(ErrorResponse.class, new Annotation[0]);
        return errorConverter.convert(responsebody);
    }
}
