package com.ssv.keepsolid.presenter.login_presenter;

import com.ssv.keepsolid.model.LoginModelRequest;

public interface LoginPresenter {
    void Login(LoginModelRequest loginModelRequest);

    String getDeviceId();

    String getDeviceName();

    String getPlatform();

    String getPlatformVersion();

    String getAppVersion();

    String getLocale();

    String getTimeZone();
}
