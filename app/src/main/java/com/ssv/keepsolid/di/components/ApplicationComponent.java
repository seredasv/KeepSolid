package com.ssv.keepsolid.di.components;

import com.ssv.keepsolid.di.modules.ApplicationModule;
import com.ssv.keepsolid.di.modules.LoginModule;
import com.ssv.keepsolid.di.modules.TasksModule;
import com.ssv.keepsolid.view.MainApplication;
import com.ssv.keepsolid.view.activities.MainActivity;
import com.ssv.keepsolid.view.fragments.LoginFragment;
import com.ssv.keepsolid.view.fragments.TasksFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class, TasksModule.class})
public interface ApplicationComponent {
    void inject(MainApplication mainApplication);

    void inject(MainActivity mainActivity);

    void inject(LoginFragment loginFragment);

    void inject(TasksFragment tasksFragment);
}
