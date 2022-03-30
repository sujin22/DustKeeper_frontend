package com.example.dustkeeper.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
    @SerializedName("returnReasonCode")
    int returnReasonCode;

    @SerializedName("returnAuthMsg")
    String returnAuthMsg;

    @SerializedName("errMsg")
    String errMsg;

    public int getCode() {
        return returnReasonCode;
    }

    public String getErrMessage() {
        return errMsg;
    }

    public String getReturnAuthMsg(){
        return returnAuthMsg;
    }
}
