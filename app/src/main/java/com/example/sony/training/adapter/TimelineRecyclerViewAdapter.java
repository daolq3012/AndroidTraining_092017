package com.example.sony.training.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.sony.training.ItemTimeLine;
import com.example.sony.training.R;
import java.util.List;

/**
 * Created by Administrator on 11/08/17.
 */

public class TimelineRecyclerViewAdapter extends RecyclerView.Adapter<TimelineRecyclerViewAdapter.RecyclerViewHolder> {

    private List<ItemTimeLine> mList;

    public TimelineRecyclerViewAdapter(List<ItemTimeLine> list) {
        mList = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_timeline_layout, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.mImageView.setBackgroundResource(mList.get(position).getImage());
        holder.mTextView.setText(mList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.timelineImageView);
            mTextView = (TextView) itemView.findViewById(R.id.timelineTextView);
        }
    }
}
