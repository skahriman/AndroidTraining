package com.example.sefakkahriman.magicleapcoffeeappassignment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sefakkahriman.magicleapcoffeeappassignment.DetailActivity;
import com.example.sefakkahriman.magicleapcoffeeappassignment.R;
import com.example.sefakkahriman.magicleapcoffeeappassignment.model.CoffeeResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder>{

    private Context context;
    private List<CoffeeResponse> list;

    public CoffeeAdapter(Context context, List<CoffeeResponse> list) {
        this.context = context;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        if (!list.get(position).getImageUrl().trim().equals("")) {
            Picasso.get().load(list.get(position).getImageUrl()).into(holder.imageUrl);
        }
        holder.name.setText(list.get(position).getName());
        holder.ID.setText(list.get(position).getId());
        holder.desc.setText(list.get(position).getDesc());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "You clicked on " + list.get(position).getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailActivity.class);
                String id = list.get(position).getId();
                intent.putExtra("ID", id);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView imageUrl;
        TextView name;
        TextView ID;
        TextView desc;

        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            imageUrl = itemView.findViewById(R.id.imageUrl);
            name = itemView.findViewById(R.id.name);
            ID = itemView.findViewById(R.id.ID);
            desc = itemView.findViewById(R.id.desc);

            linearLayout = itemView.findViewById(R.id.linear_layout);

        }
    }
}
