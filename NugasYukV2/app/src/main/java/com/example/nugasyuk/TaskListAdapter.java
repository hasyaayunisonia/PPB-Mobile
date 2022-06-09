package com.example.nugasyuk;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class TaskListAdapter extends ListAdapter<Task, TaskViewHolder> {
    Context context;

    public TaskListAdapter(@NonNull DiffUtil.ItemCallback<Task> diffCallback, Context context) {
        super(diffCallback);
        this.context = context;

    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TaskViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task currentTask = getItem(position);
        holder.bind(currentTask.getJudulTugas(),currentTask.getTanggal(), currentTask.getJam());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                Task task = new Task(currentTask.getJudulTugas(),currentTask.getTanggal(),currentTask.getJam(),currentTask.getNote());
                intent.putExtra("tugas", task);
//                intent.putExtra("tugas", currentTask.getJudulTugas());
//                intent.putExtra("deadline",currentTask.getTanggal());
//                intent.putExtra("deadline",currentTask.getJam());
//                intent.putExtra("catatan",currentTask.getNote());
                context.startActivity(intent);
            }
        });
    }

    static class TaskDiff extends DiffUtil.ItemCallback<Task> {

        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getJudulTugas().equals(newItem.getJudulTugas());
        }
    }
}