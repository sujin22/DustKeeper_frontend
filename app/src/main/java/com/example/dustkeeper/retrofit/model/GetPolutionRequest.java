package com.example.dustkeeper.retrofit.model;

import com.example.dustkeeper.BuildConfig;

public class GetPolutionRequest {
    String serviceKey;     //인증키
    String returnType;     //데이터표출방식(xml / json)
    String numOfRows;
    String pageNo;
    String dataTerm;       //요청데이터기간(DAILY / MONTH / 3MONTH)
    String ver;            //오퍼레이션 버전 : 1.3으로 호출(1시간 등급 자료 포함)

    String stationName; //측정소 이름

    public GetPolutionRequest() {
        this.serviceKey = BuildConfig.polution_key;
        this.numOfRows = "1";
        this.pageNo = "1";
        this.returnType = "json";
        this.dataTerm = "DAILY";
        this.ver = "1.3";
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return  "serviceKey='" + serviceKey +
                "&returnType='" + returnType +
                "&numOfRows='" + numOfRows +
                "&pageNo='" + pageNo +
                "&dataTerm='" + dataTerm +
                "&ver='" + ver +
                "&stationName='" + stationName;
    }
}
