package com.example.sefakkahriman.app2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sefakkahriman.app2.data.Person;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private Context context;
    private List<Person> personList;

    public RecyclerViewAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etFirstName.setText(personList.get(position).getFirstName());
        holder.etLastName.setText(personList.get(position).getLastName());
        holder.etAddress.setText(personList.get(position).getAddress());
        holder.etGender.setText(personList.get(position).getGender());
        holder.etAge.setText(personList.get(position).getAge());

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView etFirstName;
        TextView etLastName;
        TextView etAddress;
        TextView etGender;
        TextView etAge;

        public ViewHolder(View itemView) {
            super(itemView);
            etFirstName = itemView.findViewById(R.id.etFirstName);
            etLastName = itemView.findViewById(R.id.etLastName);
            etAddress = itemView.findViewById(R.id.etAddress);
            etGender = itemView.findViewById(R.id.etGender);
            etAge = itemView.findViewById(R.id.etAge);

        }
    }
}
