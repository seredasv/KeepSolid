package com.ssv.keepsolid.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ssv.keepsolid.R;
import com.ssv.keepsolid.presenter.tasks_presenter.TasksPresenter;
import com.ssv.keepsolid.view.MainApplication;
import com.ssv.keepsolid.view.adapters.TasksAdapter;
import javax.inject.Inject;

public class TasksFragment extends Fragment {
    @Inject
    protected TasksPresenter presenter;
    @Inject
    protected Context context;

    private RecyclerView recyclerView;
    private TasksAdapter adapter;

    public static TasksFragment newInstance() {
        return new TasksFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getActivity().getApplication()).getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        findView(view);

        createAdapter();

        return view;
    }

    private void findView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    }

    private void createAdapter() {
        adapter = new TasksAdapter(presenter.getTasks());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
