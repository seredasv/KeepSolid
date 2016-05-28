package com.ssv.keepsolid.model;

public class LoginModelRequest {
    private String login;
    private String password;
    private String deviceId;
    private String deviceName;
    private String platform;
    private String platformVersion;
    private String appVersion;
    private String locale;
    private String timeZone;
    private String action;
    private String service;

    public LoginModelRequest(String login, String password, String deviceId, String deviceName, String platform,
                             String platformVersion, String appVersion, String locale, String timeZone,
                             String action, String service) {
        this.login = login;
        this.password = password;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.platform = platform;
        this.platformVersion = platformVersion;
        this.appVersion = appVersion;
        this.locale = locale;
        this.timeZone = timeZone;
        this.action = action;
        this.service = service;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
