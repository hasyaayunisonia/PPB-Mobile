package com.example.nugasyuk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private final TextView JudulView;
    private final TextView TanggalView;
    private final TextView JamView;
    ConstraintLayout mainLayout;

    private TaskViewHolder(View itemView){
        super(itemView);
        JudulView = itemView.findViewById(R.id.titleview);
        TanggalView = itemView.findViewById(R.id.tanggalview);
        JamView = itemView.findViewById(R.id.jamview);
        mainLayout = itemView.findViewById(R.id.mainLayout);
    }

    public void bind(String judul, String tanggal, String jam){
        JudulView.setText(judul);
        TanggalView.setText(tanggal);
        JamView.setText(jam);
    }

    static TaskViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_tugas,parent,false);
        return new TaskViewHolder(view);
    }

}
