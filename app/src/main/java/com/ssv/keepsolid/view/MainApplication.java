package com.ssv.keepsolid.view;

import android.app.Application;
import com.ssv.keepsolid.di.components.ApplicationComponent;
import com.ssv.keepsolid.di.components.DaggerApplicationComponent;
import com.ssv.keepsolid.di.modules.ApplicationModule;
import com.ssv.keepsolid.di.modules.LoginModule;
import com.ssv.keepsolid.di.modules.TasksModule;

public class MainApplication extends Application {
    private static ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        dependencyInjections();
    }

    private void dependencyInjections() {
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .tasksModule(new TasksModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return appComponent;
    }
}
