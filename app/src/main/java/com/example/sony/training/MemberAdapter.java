package com.example.sony.training;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by phong on 11/17/17.
 */

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
    private List<Member> members;
    private OnItemRecyclerViewClick mOnItemRecyclerViewClick;

    public MemberAdapter(List<Member> members) {
        this.members = members;
    }

    public void setOnItemRecyclerViewClick(OnItemRecyclerViewClick onItemRecyclerViewClick) {
        mOnItemRecyclerViewClick = onItemRecyclerViewClick;
    }

    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_row, parent, false);
        return new ViewHolder(view, mOnItemRecyclerViewClick);
    }

    @Override
    public void onBindViewHolder(MemberAdapter.ViewHolder holder, int position) {
        holder.rowId.setText(members.get(position).getId());
        holder.rowName.setText(members.get(position).getName());
        holder.rowAge.setText(members.get(position).getAge());
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView rowId;
        public TextView rowName;
        public TextView rowAge;
        private OnItemRecyclerViewClick mOnItemRecyclerViewClick;
        private int position = 0;

        public ViewHolder(View itemView, final OnItemRecyclerViewClick onItemRecyclerViewClick) {
            super(itemView);
            rowId = itemView.findViewById(R.id.rowId);
            rowName = itemView.findViewById(R.id.rowName);
            rowAge = itemView.findViewById(R.id.rowAge);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemRecyclerViewClick = onItemRecyclerViewClick;
                    mOnItemRecyclerViewClick.OnItemClick(position);
                }
            });
        }
    }
}
