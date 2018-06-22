package com.example.sefakkahriman.recyclerviewdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.sefakkahriman.recyclerviewdemo.R;
import com.example.sefakkahriman.recyclerviewdemo.model.Person;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<Person> personLIst;

    public RecyclerViewAdapter(ArrayList<Person> personLIst) {
        this.personLIst = personLIst;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.personName.setText(personLIst.get(position).getName());
        holder.personLastName.setText(personLIst.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        //returns number of elements in personList
        return personLIst.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView personName;
        TextView personLastName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            personName = itemView.findViewById(R.id.personNameID);
            personLastName = itemView.findViewById(R.id.personLastNameID);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
