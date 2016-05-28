package com.ssv.keepsolid.presenter.tasks_presenter;

import android.content.Context;
import com.ssv.keepsolid.model.TaskModel;
import java.util.ArrayList;
import javax.inject.Inject;

public class TasksPresenterImpl implements TasksPresenter {
    @Inject
    Context context;

    @Inject
    public TasksPresenterImpl(Context context) {
        this.context = context;
    }

    @Override
    public ArrayList<TaskModel> getTasks() {
        ArrayList<TaskModel> list = new ArrayList<>();

        return list;
    }
}
