package com.example.desafiotalana.IO.RESPONSES;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("STATUS")
    private String status;
    @SerializedName("api-token")
    private String token;

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }
}
