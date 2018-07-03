package com.example.sefakkahriman.customadapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Person> {

    ArrayList<Person> personList;

    public CustomAdapter(Context context, ArrayList<Person> list) {
        super(context, 0, list);
        personList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.list_item, null);

        TextView firstName = view.findViewById(R.id.idFirstName);
        TextView lastName = view.findViewById(R.id.idLastName);

        firstName.setText(personList.get(position).getFirstName());
        lastName.setText(personList.get(position).getLastName());

        return view;
    }
}
