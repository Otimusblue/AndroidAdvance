package com.example.macintoshhd.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<DataModel> mDataAdapters;

    DataAdapter(List<DataModel> dataAdapters) {
        mDataAdapters = dataAdapters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.tvShow.setText(mDataAdapters.get(i).getName());
        viewHolder.imgShow.setImageResource(mDataAdapters.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return mDataAdapters != null ? mDataAdapters.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvShow;
        ImageView imgShow;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvShow = itemView.findViewById(R.id.tv_1);
            imgShow = itemView.findViewById(R.id.img_1);
        }
    }
}
