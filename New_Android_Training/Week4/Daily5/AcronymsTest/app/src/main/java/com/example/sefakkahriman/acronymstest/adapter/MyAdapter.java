package com.example.sefakkahriman.acronymstest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sefakkahriman.acronymstest.Item;
import com.example.sefakkahriman.acronymstest.R;
import com.example.sefakkahriman.acronymstest.data.LfsItem;
import com.example.sefakkahriman.acronymstest.data.Response;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<LfsItem> list;

    public MyAdapter(List<LfsItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.freq.setText(String.valueOf(list.get(position).getFreq()));
        holder.lf.setText(list.get(position).getLf());
        holder.since.setText(String.valueOf(list.get(position).getSince()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView freq;
        TextView lf;
        TextView since;

        public ViewHolder(View itemView) {
            super(itemView);

            freq = itemView.findViewById(R.id.freq);
            lf = itemView.findViewById(R.id.lf);
            since = itemView.findViewById(R.id.since);

        }
    }
}
