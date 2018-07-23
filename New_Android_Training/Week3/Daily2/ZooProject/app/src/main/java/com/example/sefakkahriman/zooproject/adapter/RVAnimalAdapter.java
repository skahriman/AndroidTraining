package com.example.sefakkahriman.zooproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sefakkahriman.zooproject.AnimalDetail;
import com.example.sefakkahriman.zooproject.data.Animal;
import com.example.sefakkahriman.zooproject.R;

import java.util.List;


public class RVAnimalAdapter extends RecyclerView.Adapter<RVAnimalAdapter.ViewHolder> {

    List<Animal> animalList;
    Context context;

    public static final String TAG = RVAnimalAdapter.class.getSimpleName() + "_TAG";

    public RVAnimalAdapter(List<Animal> animals, Context context) {
        this.animalList = animals;
        this.context = context;
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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: " + viewHolder.toString());
        Animal animal = animalList.get(i);

        viewHolder.tvCategory.setText(animal.getCategory());
        viewHolder.tvName.setText(animal.getName());
        viewHolder.tvWeight.setText(String.valueOf(animal.getWeight()));
        viewHolder.tvSound.setText(animal.getSound());
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked " + animalList.get(i).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, AnimalDetail.class);

                intent.putExtra("category", animalList.get(i).getCategory());
                intent.putExtra("name", animalList.get(i).getName());
                intent.putExtra("weight", animalList.get(i).getWeight());
                intent.putExtra("sound", animalList.get(i).getSound());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvCategory;
        private final TextView tvName;
        private final TextView tvWeight;
        private final TextView tvSound;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvName = itemView.findViewById(R.id.tvName);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            tvSound = itemView.findViewById(R.id.tvSound);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
