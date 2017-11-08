package com.example.sony.training;


import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThanhThang on 07/11/2017.
 */

public class RecyclerViewAdapterTimeLines extends RecyclerView.Adapter<RecyclerViewAdapterTimeLines.RecyclerViewHolder> {
    private List<TimeLines> timeLines = new ArrayList<>();

    public RecyclerViewAdapterTimeLines(List<TimeLines> timeLines) {
        this.timeLines = timeLines;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_timelines_layout, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

       //holder.imageView.setImageResource(Integer.parseInt(timeLines.get(position).getmImage()));

        holder.textView.setText(timeLines.get(position).getmName());
    }

    @Override
    public int getItemCount() {
        return timeLines.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imgID);
            textView = (TextView) itemView.findViewById(R.id.tv_tv);
        }
    }
}
