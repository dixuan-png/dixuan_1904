package com.example.dixuan_1904.repository.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dixuan_1904.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<RecyclerBean.DataBean.DatasBean> list = new ArrayList<>();

    public List<RecyclerBean.DataBean.DatasBean> getList() {
        return list;
    }

    public void setList(List<RecyclerBean.DataBean.DatasBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    private Context context;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recy_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerBean.DataBean.DatasBean datasBean = list.get(position);
        holder.title.setText(datasBean.getTitle());
        holder.desc.setText(datasBean.getDesc());
        Glide.with(context).load(datasBean.getEnvelopePic()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,desc;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            image = itemView.findViewById(R.id.image);
        }
    }
}
