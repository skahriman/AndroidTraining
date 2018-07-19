package com.example.sefakkahriman.restcallproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sefakkahriman.restcallproject.R;
import com.example.sefakkahriman.restcallproject.model.GitHubRepo;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    List<GitHubRepo> repoList;

    public RepoAdapter(List<GitHubRepo> repoList) {
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repo_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.language.setText(repoList.get(position).getLanguage());
        holder.name.setText(repoList.get(position).getName());
        holder.updatedAt.setText(repoList.get(position).getUpdatedAt());
        holder.node_id.setText(repoList.get(position).getNodeId());


    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView language;
        private TextView name;
        private TextView updatedAt;
        private TextView node_id;

        public ViewHolder(View itemView) {
            super(itemView);

            language = itemView.findViewById(R.id.language);
            name = itemView.findViewById(R.id.name);
            updatedAt = itemView.findViewById(R.id.updatedAt);
            node_id = itemView.findViewById(R.id.node_id);

        }
    }
}
