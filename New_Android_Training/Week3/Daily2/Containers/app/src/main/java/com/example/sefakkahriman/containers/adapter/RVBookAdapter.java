package com.example.sefakkahriman.containers.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sefakkahriman.containers.model.Book;
import com.example.sefakkahriman.containers.R;

import java.util.List;

public class RVBookAdapter extends RecyclerView.Adapter<RVBookAdapter.ViewHolder> {

    List<Book> books;
    public static final String TAG = RVBookAdapter.class.getSimpleName() + "_TAG";

    public RVBookAdapter(List<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: ");

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.book_list_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: " + viewHolder.toString());
        Book book = books.get(i);

        viewHolder.tvISBN.setText(book.getISBN());
        viewHolder.tvName.setText(book.getName());
        viewHolder.tvAuthor.setText(book.getAuthor());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvISBN;
        private final TextView tvName;
        private final TextView tvAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvISBN = itemView.findViewById(R.id.tvISBN);
            tvName = itemView.findViewById(R.id.tvName);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
        }
    }
}
