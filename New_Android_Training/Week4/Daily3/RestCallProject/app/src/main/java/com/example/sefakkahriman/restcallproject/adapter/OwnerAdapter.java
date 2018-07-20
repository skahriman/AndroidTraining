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
        holder.login.setText(list.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView login;

        public ViewHolder(View itemView) {
            super(itemView);

            login = itemView.findViewById(R.id.login);
        }
    }
}
