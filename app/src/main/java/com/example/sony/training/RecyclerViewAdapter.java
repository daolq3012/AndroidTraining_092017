package com.example.sony.training;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/04/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private List<Item> list = new ArrayList<>();

    public RecyclerViewAdapter(List<Item> list) {
        this.list = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // them itemlayout vao  trong recycler. giup recycler biet dc view nao can the hien
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_layout, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.mTxtName.setText(list.get(i).getName());
        recyclerViewHolder.mTxtAge.setText(list.get(i).getAge()+"");
    }

    @Override
    public int getItemCount() {
        return list.size()  ;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView mTxtName, mTxtAge;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mTxtName = (TextView) itemView.findViewById(R.id.nameTextView);
            mTxtAge = (TextView) itemView.findViewById(R.id.ageTextView);
        }
    }
}
