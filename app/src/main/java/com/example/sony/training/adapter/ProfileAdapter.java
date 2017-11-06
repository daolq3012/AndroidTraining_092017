package com.example.sony.training.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sony.training.R;
import com.example.sony.training.model.Person;
import com.example.sony.training.model.Timeline;

import java.util.List;

/**
 * Created by Admin on 11/06/17.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileHolder> {

        private List<Person> listItem;
        private LayoutInflater inflater;
        private Context context;

        public ProfileAdapter(List<Person> listItem, Context context) {
            this.inflater = LayoutInflater.from(context);
            this.listItem = listItem;
            this.context = context;
        }

        @Override
        public ProfileHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.profile_item,parent,false);
            return new ProfileHolder(view);
        }

        @Override
        public void onBindViewHolder(ProfileHolder holder, int position) {
            Person person = listItem.get(position);
            holder.name.setText(person.getName());
        }

        @Override
        public int getItemCount() {
            return listItem.size();
        }

        class ProfileHolder extends RecyclerView.ViewHolder {
            private TextView name;

            public ProfileHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.item_time);
            }
        }
}
