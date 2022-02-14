package com.example.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;


public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    /* menambahkan WordViewHolder */
    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
        }
    }
    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

//    @NonNull
//    @Override
//    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder wordViewHolder, int i) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }



}
