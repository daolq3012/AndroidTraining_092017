package com.example.sony.training.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sony.training.R;
import com.example.sony.training.RegisterActivity;
import com.example.sony.training.model.Timeline;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Admin on 11/06/17.
 */

public class TimelinesAdapter extends RecyclerView.Adapter<TimelinesAdapter.TimelinesHolder> {

    private List<Timeline> listItem;
    private LayoutInflater inflater;
    private Context context;

    public TimelinesAdapter(List<Timeline> listItem, Context context) {
        this.inflater = LayoutInflater.from(context);
        this.listItem = listItem;
        this.context = context;
    }

    @Override
    public TimelinesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.timeline_item,parent,false);
        return new TimelinesHolder(view);
    }

    @Override
    public void onBindViewHolder(TimelinesHolder holder, int position) {
        Timeline timeline = listItem.get(position);
        Glide.with(context).load(timeline.getAvatar()).into(holder.avatar);
        holder.content.setText(timeline.getContent());
        holder.time.setText(timeline.getTime());
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    class TimelinesHolder extends RecyclerView.ViewHolder {
        private CircleImageView avatar;
        private TextView time,content;

        public TimelinesHolder(View itemView) {
            super(itemView);

            avatar = (CircleImageView) itemView.findViewById(R.id.item_avatar);
            content = (TextView) itemView.findViewById(R.id.item_content);
            time = (TextView) itemView.findViewById(R.id.item_time);
        }
    }
}
