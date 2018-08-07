package com.example.sefakkahriman.retrofitdemo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GithubRepoAdapter extends RecyclerView.Adapter<GithubRepoAdapter.WordViewHolder> {

    private final LayoutInflater mInflater;
    private List<GithubRepoResponse> repos; // Cached copy of words

    GithubRepoAdapter(Context context, List<GithubRepoResponse> repos) {
        mInflater = LayoutInflater.from(context);
        this.repos = repos;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (repos != null) {
            GithubRepoResponse current = repos.get(position);
            holder.repoName.setText(current.getName());

        } else {
            // Covers the case of data not being ready yet.
            holder.repoName.setText("No Word");
        }
    }

    // getItemCount() is called many times, and when it is first called,
    // repos has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (repos != null)
            return repos.size();
        else return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {

        private final TextView repoName;

        private WordViewHolder(View itemView) {
            super(itemView);
            repoName = itemView.findViewById(R.id.repoName);
        }
    }
}
