package com.example.dustkeeper.retrofit;

import com.example.dustkeeper.retrofit.model.ErrorResponse;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient{
    public static Retrofit retrofit;
    public static RetrofitService retrofitService;

    //싱글톤으로 생성
    public static Retrofit getRetrofit(){
        if(retrofit == null){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            builder.readTimeout(10000, TimeUnit.MILLISECONDS)
                    .connectTimeout(10000, TimeUnit.MILLISECONDS)
                    .addInterceptor(loggingInterceptor);

            OkHttpClient client = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
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
