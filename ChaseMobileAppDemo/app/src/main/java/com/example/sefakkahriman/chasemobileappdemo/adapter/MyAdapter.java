package com.example.sefakkahriman.chasemobileappdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sefakkahriman.chasemobileappdemo.AccountDetailActivity;
import com.example.sefakkahriman.chasemobileappdemo.R;
import com.example.sefakkahriman.chasemobileappdemo.adapter_model.ListItem;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ListItem> listitems;

    public MyAdapter(Context context, List listitems) {
        this.context = context;
        this.listitems = listitems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        final ListItem item = listitems.get(position);
        holder.title.setText(item.getTitle());
        holder.balance.setText(item.getBalance());
        holder.availableBalance.setText(item.getAvailableBalance());

        //This part is handling click on RecyclerView items
        holder.linearLayout.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, AccountDetailActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    // holds all items
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView balance;
        public TextView availableBalance;

        //This part is handling click on RecyclerView items
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.balance = itemView.findViewById(R.id.balance);
            this.availableBalance = itemView.findViewById(R.id.availableBalance);

            //This part is handling click on RecyclerView items
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
