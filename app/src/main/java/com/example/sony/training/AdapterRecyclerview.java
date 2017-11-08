package com.example.sony.training;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 11/08/17.
 */

public class AdapterRecyclerview extends  RecyclerView.Adapter<AdapterRecyclerview.viewHolder>{
    ArrayList<datashop>datashops;
    Context context;

    public AdapterRecyclerview(ArrayList<datashop> datashops, Context context) {
        this.datashops = datashops;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       View itemview = layoutInflater.inflate(R.layout.layoutrecyclerview,parent,false);
        return new viewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        holder.txtname(datashops.get(position).getTxtname());
        holder.txtgia(datashops.get(position).getTxtprice());
        holder.imghinh(datashops.get(position).getHinhanh());

    }

    @Override
    public int getItemCount() {
        return datashops.size();
    }

    public  class  viewHolder extends RecyclerView.ViewHolder{
            ImageView imghinh;
            TextView  txtname;
            TextView  txtgia;

        public viewHolder(View itemView) {
            super(itemView);

            imghinh = (ImageView)itemView.findViewById(R.id.imghinh);
            txtname = (TextView)itemView.findViewById(R.id.txtname);
            txtgia  = (TextView)itemView.findViewById(R.id.txtgia);


        }
    }
}
