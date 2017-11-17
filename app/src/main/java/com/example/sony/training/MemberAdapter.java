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

class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
    private List<Member> members;

    public MemberAdapter(List<Member> members) {
        this.members = members;
    }

    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MemberAdapter.ViewHolder holder, int position) {
        holder.rowName.setText(members.get(position).getName());
        holder.rowAge.setText(members.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView rowName;
        public TextView rowAge;

        public ViewHolder(View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.rowName);
            rowAge = itemView.findViewById(R.id.rowAge);
        }
    }
}
