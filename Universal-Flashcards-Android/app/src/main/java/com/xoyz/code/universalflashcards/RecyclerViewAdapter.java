package com.xoyz.code.universalflashcards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewholder> {
    private ArrayList<RecyclerViewItem> mrecyclerViewItems;

    public static class RecyclerViewholder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView_main;
        public TextView mTextView_sub;

        public RecyclerViewholder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView_main = itemView.findViewById(R.id.main_text);
            mTextView_sub = itemView.findViewById(R.id.sub_text);
        }
    }

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> recyclerViewItemArrayList) {
        mrecyclerViewItems = recyclerViewItemArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        RecyclerViewholder rvh = new RecyclerViewholder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewholder holder, int position) {
        RecyclerViewItem currentItem = mrecyclerViewItems.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView_main.setText(currentItem.getMain_text());
        holder.mTextView_sub.setText(currentItem.getSub_text());
    }

    @Override
    public int getItemCount() {
        return mrecyclerViewItems.size();
    }
}