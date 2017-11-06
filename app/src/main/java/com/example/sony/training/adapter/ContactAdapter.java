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
import com.example.sony.training.model.Contact;

import java.util.List;

/**
 * Created by Admin on 11/06/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private List<Contact> listItem;
    private Context context;

    public ContactAdapter(List<Contact> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.contact_item,parent,false);
        return new ContactHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        Contact contact = listItem.get(position);
        Glide.with(context).load(contact.getAvatar()).into(holder.avatar);
        holder.name.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    class ContactHolder extends RecyclerView.ViewHolder {
        private ImageView avatar;
        private TextView name;
        private TextView phoneNumber;

        public ContactHolder(View itemView) {
            super(itemView);

            avatar = (ImageView) itemView.findViewById(R.id.item_avatar);
            name = (TextView) itemView.findViewById(R.id.item_name);
            phoneNumber = (TextView) itemView.findViewById(R.id.item_phone_number);
        }
    }
}
