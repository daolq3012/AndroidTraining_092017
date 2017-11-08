package com.example.sony.training;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThanhThang on 06/11/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{
    private List<Infor> infor = new ArrayList<>();
    public RecyclerViewAdapter(List<Infor> infor){
        this.infor = infor;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.mName.setText(infor.get(position).getName());
        holder.mNinja.setText(infor.get(position).getLv());

    }

    @Override
    public int getItemCount() {
        return infor.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mNinja;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.nameOj);
            mNinja = (TextView) itemView.findViewById(R.id.lvninja);
        }
    }
}
