package com.example.sefakkahriman.zooproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sefakkahriman.zooproject.data.Animal;
import com.example.sefakkahriman.zooproject.R;

import java.util.List;

public class CVAnimalAdapter extends RecyclerView.Adapter<CVAnimalAdapter.ViewHolder> {

    List<Animal> animalList;

    public CVAnimalAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.single_animal_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
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
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.cvName);
            tvWeight = itemView.findViewById(R.id.cvWeight);
            tvSound = itemView.findViewById(R.id.cvSound);

            linearLayout = itemView.findViewById(R.id.cvLinearLayout);

        }
    }
}
