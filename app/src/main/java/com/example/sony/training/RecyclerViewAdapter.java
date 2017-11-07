package com.example.sony.training;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/06/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private Context mContext;
    private List<User> mList = new ArrayList<>();

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }
    public void updateData(List<User> mList){
        this.mList = mList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        String user = mList.get(position).getName() + " Tuoi: " + mList.get(position).getAge();
        holder.mTextView.setText(user);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.nameTextView);
        }
    }
}
