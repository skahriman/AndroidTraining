package com.example.sefakkahriman.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    List<Person> personList;

    public MyRecyclerViewAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_itemlist, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.personName.setText(personList.get(position).getName());
        holder.personLastName.setText(personList.get(position).getLastName());

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView personName;
        TextView personLastName;
        RelativeLayout parent;

        public ViewHolder(View itemView) {
            super(itemView);

            personName = itemView.findViewById(R.id.personNameID);
            personLastName = itemView.findViewById(R.id.personLastNameID);
            parent = itemView.findViewById(R.id.parent_layout);
        }
    }
}
