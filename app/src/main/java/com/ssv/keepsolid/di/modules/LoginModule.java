package com.ssv.keepsolid.di.modules;

import com.ssv.keepsolid.presenter.login_presenter.LoginPresenter;
import com.ssv.keepsolid.presenter.login_presenter.LoginPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter(LoginPresenterImpl loginPresenter) {
        return loginPresenter;
    }
}
