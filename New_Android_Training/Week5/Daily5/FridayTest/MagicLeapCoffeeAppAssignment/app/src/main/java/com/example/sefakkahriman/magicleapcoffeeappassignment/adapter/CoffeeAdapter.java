package com.example.sefakkahriman.magicleapcoffeeappassignment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.sefakkahriman.magicleapcoffeeappassignment.R;
import com.example.sefakkahriman.magicleapcoffeeappassignment.model.CoffeeResponse;

import java.util.ArrayList;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder>{

    private ArrayList<CoffeeResponse> list;

    public CoffeeAdapter(ArrayList<CoffeeResponse> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.ID.setText(list.get(position).getId());
        holder.desc.setText(list.get(position).getDesc());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView imageUrl;
        EditText name;
        EditText ID;
        EditText desc;

        public ViewHolder(View itemView) {
            super(itemView);

            imageUrl = itemView.findViewById(R.id.imageURL);
            name = itemView.findViewById(R.id.name);
            ID = itemView.findViewById(R.id.ID);
            desc = itemView.findViewById(R.id.desc);

        }
    }
}
