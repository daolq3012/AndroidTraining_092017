package com.example.sony.training;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/06/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private Context mContext;

    private List<User> mStrings = new ArrayList<>();

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void updateData(List<User> strings) {
        mStrings = strings;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_recyclerview,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        User user = mStrings.get(position);
        String text = user.getName() + " Tuoi: " + user.getAge();
        itemViewHolder.setDataIntoTextView(text);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textViewName);
        }

        public void setDataIntoTextView(String s) {
            mTextView.setText(s);
        }
    }
}
