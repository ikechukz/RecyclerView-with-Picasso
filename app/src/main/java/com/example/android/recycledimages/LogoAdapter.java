package com.example.android.recycledimages;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LogoAdapter extends RecyclerView.Adapter<LogoAdapter.ViewHolder> {
    private ArrayList<Logo> images;
    //private Context context;

    public LogoAdapter(Context context, ArrayList<Logo> images) {
        //this.context = context;
        this.images = images;

    }

    @Override
    public LogoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //set layout to item using LayoutInfalter
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {



        // Picasso.get().load(vehicle_logo.get(i).getLogo_image_link()).into(viewHolder.img_logo);

        Picasso.get()
                .load(images.get(i).getLogo_image_link())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.stat_notify_error)
                .into(viewHolder.img_logo);

    }


    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_logo;

        public ViewHolder(View view) {
            super(view);
            //initialise imageView
            img_logo = (ImageView) view.findViewById(R.id.img_man);
        }
    }
}