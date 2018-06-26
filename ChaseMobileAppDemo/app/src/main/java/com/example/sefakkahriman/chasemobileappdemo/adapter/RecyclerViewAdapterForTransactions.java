package com.example.sefakkahriman.chasemobileappdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sefakkahriman.chasemobileappdemo.R;
import com.example.sefakkahriman.chasemobileappdemo.model.Transaction;

import java.util.List;

public class RecyclerViewAdapterForTransactions extends
        RecyclerView.Adapter<RecyclerViewAdapterForTransactions.ViewHolder> {

    private Context context;
    private List<Transaction> listItems;

    public RecyclerViewAdapterForTransactions(Context context, List<Transaction> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitemfortransaction, parent, false);
        return new RecyclerViewAdapterForTransactions.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Transaction item = listItems.get(position);
        holder.place.setText(item.getPlace());
        holder.amount.setText(Double.toString(item.getAmount()));
        holder.date.setText(item.getDate());
        holder.balance.setText(Double.toString(item.getBalance()));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView place;
        private TextView date;
        private TextView amount;
        private TextView balance;

        private ConstraintLayout constraintLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            place = itemView.findViewById(R.id.tvPlace);
            date = itemView.findViewById(R.id.tvDate);
            amount = itemView.findViewById(R.id.tvAmount);
            balance = itemView.findViewById(R.id.tvBalance);
            constraintLayout = itemView.findViewById(R.id.constraintLayoutID);

        }
    }
}
