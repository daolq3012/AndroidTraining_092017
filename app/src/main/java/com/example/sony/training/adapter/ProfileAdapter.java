package com.example.sony.training.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sony.training.R;
import com.example.sony.training.model.Person;
import com.example.sony.training.model.Timeline;

import com.example.sony.training.model.UserProfile;
import java.util.List;

/**
 * Created by Admin on 11/06/17.
 */

public class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> listItems;
    private LayoutInflater inflater;
    private Context context;

    public ProfileAdapter(List<Object> listItems, Context context) {
        this.inflater = LayoutInflater.from(context);
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (listItems.get(position) instanceof UserProfile) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = inflater.inflate(R.layout.person_item, parent, false);
            return new PersonHolder(view);
        } else {
            View view = inflater.inflate(R.layout.profile_item, parent, false);
            return new ProfileHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                PersonHolder personHolder = (PersonHolder) holder;
                Person person = (Person) listItems.get(position);
                personHolder.name.setText(person.getName());
                break;
            case 1:
                ProfileHolder profileHolder = (ProfileHolder) holder;
                UserProfile userProfile = (UserProfile) listItems.get(position);
                Glide.with(context).load(userProfile.getCover()).into(profileHolder.mImgCover);
                Glide.with(context).load(userProfile.getAvatar()).into(profileHolder.mImgAvatar);
                profileHolder.mTxtName.setText(userProfile.getName());
                profileHolder.mTxtBio.setText(userProfile.getBio());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class PersonHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public PersonHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_content);
        }
    }

    class ProfileHolder extends RecyclerView.ViewHolder {
        private ImageView mImgCover;
        private ImageView mImgAvatar;
        private TextView mTxtName;
        private TextView mTxtBio;

        public ProfileHolder(View itemView) {
            super(itemView);
            mImgCover = (ImageView) itemView.findViewById(R.id.imgCover);
            mImgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
            mTxtName = (TextView) itemView.findViewById(R.id.txtNameProfile);
            mTxtBio = (TextView) itemView.findViewById(R.id.txtBioProfile);
        }
    }
}
