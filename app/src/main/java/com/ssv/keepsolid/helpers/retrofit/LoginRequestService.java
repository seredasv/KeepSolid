package com.ssv.keepsolid.helpers.retrofit;

import com.ssv.keepsolid.model.LoginModelResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface LoginRequestService {
    @POST("/")
    Call<LoginModelResponse> login(
            @Field("action") String action,
            @Field("service") String service,
            @Field("login") String login,
            @Field("password") String password,
            @Field("deviceid") String deviceId,
            @Field("device") String deviceName,
            @Field("platform") String platform,
            @Field("platformversion") String platformVersion,
            @Field("appversion") String appVersion,
            @Field("locale") String locale,
            @Field("timezone") String timeZone,
            Callback<LoginModelResponse> callback);
}
