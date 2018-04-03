package com.example.sefakkahriman.zooproject.listener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class SimpleListListener implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(view.getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}
