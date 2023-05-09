package com.lahrachtech.mvvmfullprojectusingretrofit.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lahrachtech.mvvmfullprojectusingretrofit.R;
import com.lahrachtech.mvvmfullprojectusingretrofit.bojo.ModelPost;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<ModelPost> list = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.tvUserId.setText(list.get(position).getUserId()+"");
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvBody.setText(list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<ModelPost> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserId, tvTitle, tvBody;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserId = itemView.findViewById(R.id.tvUserId);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);
        }
    }
}