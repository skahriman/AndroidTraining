package com.example.sefakkahriman.containers.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sefakkahriman.containers.R;

import com.example.sefakkahriman.containers.model.Book;

import java.util.List;

public class LVBookAdapter extends ArrayAdapter<Book> {

    List<Book> books;

    public LVBookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.book_list_layout, null);
        }

        TextView tvISBN = convertView.findViewById(R.id.tvISBN);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvAuthor = convertView.findViewById(R.id.tvAuthor);


        // bind the views  with the data

        Book book = getItem(position);
        tvISBN.setText(book.getISBN());
        tvName.setText(book.getName());
        tvAuthor.setText(book.getAuthor());

        return convertView;
    }
}
