package com.example.sefakkahriman.zooproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sefakkahriman.zooproject.data.Animal;
import com.example.sefakkahriman.zooproject.R;

import java.util.List;

public class LVAnimalAdapter extends ArrayAdapter<Animal> {

    List<Animal> animalList;

    public LVAnimalAdapter(@NonNull Context context, int resource, @NonNull List<Animal> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.categoty_list_layout, null);
        }

        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvWeight = convertView.findViewById(R.id.tvWeight);
        TextView tvSound = convertView.findViewById(R.id.tvSound);

        //bind the views with the data

        Animal animal = getItem(position);

        tvName.setText(animal.getName());
        tvWeight.setText(animal.getWeight());
        tvSound.setText(animal.getSound());


        return convertView;
    }
}
