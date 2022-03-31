package com.example.dustkeeper.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetPolutionResponse{

    Response response;

    public class Response{
        public Body body;
        public Header header;
    }

    public class Header{
        public String resultMsg;
        public String resultCode;
    }
    public class Body{
        public ArrayList<Item> items;
    }

    public class Item{
        @SerializedName("pm10Value")
        String degree; //미세먼지 농도

        @SerializedName("pm25Value")
        String ult_degree; //초미세먼지 농도
    }


    public String getDegree() {
        return response.body.items.get(0).degree;
    }

    public String getUlt_degree() {
        return response.body.items.get(0).ult_degree;
    }

}
