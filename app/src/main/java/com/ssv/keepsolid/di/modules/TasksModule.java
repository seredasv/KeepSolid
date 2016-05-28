package com.ssv.keepsolid.di.modules;

import com.ssv.keepsolid.presenter.tasks_presenter.TasksPresenter;
import com.ssv.keepsolid.presenter.tasks_presenter.TasksPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TasksModule {
    @Provides
    @Singleton
    public TasksPresenter provideLoginPresenter(TasksPresenterImpl tasksPresenter) {
        return tasksPresenter;
    }
}
