package com.ssv.keepsolid.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ssv.keepsolid.R;
import com.ssv.keepsolid.model.TaskModel;

import java.util.ArrayList;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {
    private ArrayList<TaskModel> tasks;

    public TasksAdapter(ArrayList<TaskModel> tasks) {
        this.tasks = tasks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tasks, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksAdapter.ViewHolder holder, int position) {
        TaskModel task = tasks.get(position);

        holder.tvName.setText(task.getName());
        holder.tvComment.setText(task.getComment());
        holder.tvStatus.setText(task.getStatus());
        holder.tvGroup.setText(task.getGroup());
    }

    @Override
    public int getItemCount() {
        int size = tasks.size();
        return size > 0 ? size : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvComment, tvStatus, tvGroup;

        public ViewHolder(final View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvComment = (TextView) itemView.findViewById(R.id.tv_comment);
            tvStatus = (TextView) itemView.findViewById(R.id.tv_status);
            tvGroup = (TextView) itemView.findViewById(R.id.tv_group);
        }
    }
}
