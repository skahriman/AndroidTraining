package com.example.sefakkahriman.zooproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sefakkahriman.zooproject.data.Animal;
import com.example.sefakkahriman.zooproject.R;

import java.util.List;


public class RVAnimalAdapter extends RecyclerView.Adapter<RVAnimalAdapter.ViewHolder> {

    List<Animal> animalList;
    public static final String TAG = RVAnimalAdapter.class.getSimpleName() + "_TAG";

    public RVAnimalAdapter(List<Animal> animals) {
        this.animalList = animals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: ");

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.animal_list_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: " + viewHolder.toString());
        Animal animal = animalList.get(i);

        viewHolder.tvName.setText(animal.getName());
        viewHolder.tvWeight.setText(String.valueOf(animal.getWeight()));
        viewHolder.tvSound.setText(animal.getSound());
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final TextView tvWeight;
        private final TextView tvSound;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            tvSound = itemView.findViewById(R.id.tvSound);
        }
    }
}
