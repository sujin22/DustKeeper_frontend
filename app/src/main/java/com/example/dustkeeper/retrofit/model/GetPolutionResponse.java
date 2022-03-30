package com.example.dustkeeper.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class GetPolutionResponse{
    @SerializedName("resultCode")
    int resultCode;

    @SerializedName("resultMsg")
    String resultMsg;

    @SerializedName("pm10Value")
    int degree; //미세먼지 농도

    @SerializedName("pm25Value")
    int ult_degree; //초미세먼지 농도

    public int getDegree() {
        return degree;
    }

    public int getUlt_degree() {
        return ult_degree;
    }
}
