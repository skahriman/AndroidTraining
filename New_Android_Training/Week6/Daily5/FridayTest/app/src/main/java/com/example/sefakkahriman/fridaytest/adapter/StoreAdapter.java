package com.example.sefakkahriman.fridaytest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sefakkahriman.fridaytest.model.Store;

import java.util.List;

import com.example.sefakkahriman.fridaytest.R;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{

    List<Store> storeList;
    Context context;

    public StoreAdapter(List<Store> storeList, Context context) {
        this.storeList = storeList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pagination, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.storeId.setText(storeList.get(position).getStoreId());
        holder.addressDesc.setText(storeList.get(position).getAddressDescription());
        holder.hoursDesc.setText(storeList.get(position).getHoursDescription());
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView storeId;
        private TextView addressDesc;
        private TextView hoursDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            storeId = itemView.findViewById(R.id.tvStoreId);
            addressDesc = itemView.findViewById(R.id.tvAddressDescription);
            hoursDesc = itemView.findViewById(R.id.tvHoursDescription);


        }
    }
}
