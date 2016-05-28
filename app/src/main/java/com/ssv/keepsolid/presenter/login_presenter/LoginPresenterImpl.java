package com.ssv.keepsolid.presenter.login_presenter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.ssv.keepsolid.model.LoginModelRequest;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.inject.Inject;

import cz.msebera.android.httpclient.Header;

public class LoginPresenterImpl implements LoginPresenter {
    private static final String BASE_URL_1 = "https://dev-auth.simplexsolutionsinc.com";
    private static final String BASE_URL_2 = "https://auth.simplexsolutionsinc.com";
    private static final String PLATFORM = "Android";
    private static final String TIME_ZONE_PATTERN = "ZZZZZ";

    @Inject
    Context context;

    @Inject
    public LoginPresenterImpl(Context context) {
        this.context = context;
    }

    @Override
    public void Login(LoginModelRequest model) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL_1)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        LoginRequestService service = retrofit.create(LoginRequestService.class);
//        service.login(model.getAction(), model.getService(), model.getLogin(), model.getPassword(),
//                model.getDeviceId(), model.getDeviceName(), model.getPlatform(),
//                model.getPlatformVersion(), model.getAppVersion(), model.getLocale(), model.getTimeZone(), new Callback<LoginModelResponse>() {
//                    @Override
//                    public void onResponse(Call<LoginModelResponse> call, Response<LoginModelResponse> response) {
//                    }
//
//                    @Override
//                    public void onFailure(Call<LoginModelResponse> call, Throwable t) {
//                    }
//                });

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("action", model.getAction());
        params.put("service", model.getService());
        params.put("login", "kscheck004@mailinator.com");
        params.put("password", "123456");
        params.put("deviceid", model.getDeviceId());
        params.put("device", model.getDeviceName());
        params.put("platform", model.getPlatform());
        params.put("platformversion", model.getPlatformVersion());
        params.put("appversion", model.getAppVersion());
        params.put("locale", model.getLocale());
        params.put("timezone", model.getTimeZone());

        client.post(BASE_URL_1, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }

    @Override
    public String getDeviceId() {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return manager.getDeviceId();
    }

    @Override
    public String getDeviceName() {
        return Build.MODEL;
    }

    @Override
    public String getPlatform() {
        return PLATFORM;
    }

    @Override
    public String getPlatformVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override
    public String getAppVersion() {
        PackageInfo info = null;
        try {
            info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return String.valueOf(info != null ? info.versionCode : "null");
    }

    @Override
    public String getLocale() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    @Override
    public String getTimeZone() {
        return new SimpleDateFormat(TIME_ZONE_PATTERN, Locale.getDefault()).format(System.currentTimeMillis());
    }
}
