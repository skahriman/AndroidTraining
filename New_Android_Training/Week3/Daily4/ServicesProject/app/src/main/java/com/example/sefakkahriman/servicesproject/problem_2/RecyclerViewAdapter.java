package com.example.sefakkahriman.servicesproject.problem_2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sefakkahriman.servicesproject.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Person> personList;

    public RecyclerViewAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.person_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Person person = personList.get(i);

        viewHolder.name.setText(person.name);
        viewHolder.title.setText(person.title);
        viewHolder.type.setText(person.type);

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView title;
        private final TextView type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            type = itemView.findViewById(R.id.type);
        }
    }
}
