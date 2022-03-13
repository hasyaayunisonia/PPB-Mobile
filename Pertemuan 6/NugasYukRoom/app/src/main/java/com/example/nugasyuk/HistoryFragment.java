package com.example.nugasyuk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HistoryFragment extends Fragment {

    String[] string1;
    String[] string2;
    String[] string3;
    RecyclerView recyclerview;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        string1 = getResources().getStringArray(R.array.list_tugas_selesai);
        string3 = getResources().getStringArray(R.array.deskripsi_selesai);
        string2 = getResources().getStringArray(R.array.tanggal_selesai);
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        //taskAdapter myAdapter = new taskAdapter(getContext(), string1,string2, string3);
        recyclerview = view.findViewById(R.id.recyclerViewHistory);
        //recyclerview.setAdapter(myAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}