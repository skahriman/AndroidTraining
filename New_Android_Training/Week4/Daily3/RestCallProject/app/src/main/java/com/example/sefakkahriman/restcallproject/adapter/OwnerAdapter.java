package com.example.sefakkahriman.restcallproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sefakkahriman.restcallproject.R;
import com.example.sefakkahriman.restcallproject.model.Owner;

import java.util.List;

public class OwnerAdapter extends RecyclerView.Adapter<OwnerAdapter.ViewHolder> {

    List<Owner> list;

    public OwnerAdapter(List<Owner> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.followersUrl.setText("Followers URL: " + list.get(position).getFollowersUrl());
        holder.id.setText("ID: " + Integer.toString(list.get(position).getId()));
        holder.avatarUrl.setText("Avatars URL: " + list.get(position).getUrl());
        holder.followersUrl.setText("Followers URL: " + list.get(position).getFollowersUrl());
        holder.reposUrl.setText("Followers URL: " + list.get(position).getReposUrl());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView followersUrl;
        TextView avatarUrl;
        TextView gravatarId;
        TextView reposUrl;

        TextView id;



        public ViewHolder(View itemView) {
            super(itemView);

            followersUrl = itemView.findViewById(R.id.followersUrl);
            avatarUrl = itemView.findViewById(R.id.avatarUrl);
            gravatarId = itemView.findViewById(R.id.gravatarId);
            id = itemView.findViewById(R.id.id);
            reposUrl = itemView.findViewById(R.id.reposUrl);
        }
    }
}
