package com.example.nugasyuk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {
    String[] string1;
    String[] string2;
    String[] string3;
    Context context;
    public TaskAdapter(Context context1, String[] s1,String[] s2, String[] s3){
        context = context1;
        string1 = s1;
        string2 = s2;
        string3 = s3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_tugas,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Text1.setText(string1[position]);
        holder.Text2.setText(string2[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("string1",string1[position]);
                intent.putExtra("string2",string2[position]);
                intent.putExtra("string3",string3[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return string1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Text1, Text2;
        ConstraintLayout mainLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Text1 = itemView.findViewById(R.id.title);
            Text2 = itemView.findViewById(R.id.tanggal);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
