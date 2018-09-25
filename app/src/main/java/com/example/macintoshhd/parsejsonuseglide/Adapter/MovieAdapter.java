package com.example.macintoshhd.parsejsonuseglide.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.macintoshhd.parsejsonuseglide.Model.Anime;
import com.example.macintoshhd.parsejsonuseglide.R;
import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context mContext;
    private List<Anime> mAnimeList;

    public MovieAdapter(Context mContext){
        mContext = mContext;
        mAnimeList = new ArrayList<>();
    }

    public void updateDate(List<Anime> animes) {
        if (mAnimeList != null) {
            mAnimeList.clear();
        }
        mAnimeList.addAll(animes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.item_row_layout,viewGroup,false);

        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

               myViewHolder.mTitle.setText(mAnimeList.get(i).getName());
               myViewHolder.mRating.setText(mAnimeList.get(i).getRating());
               myViewHolder.mCategories.setText(mAnimeList.get(i).getCategories());
               myViewHolder.mStudio.setText(mAnimeList.get(i).getStudio());

          //     Glide.with(mContext).load(mAnimeList.get(i).getImage()).into(myViewHolder.mAnimeThumbnail);
               Glide.with(mContext).load(mAnimeList.get(i).getImage()).into(myViewHolder.mAnimeThumbnail);


    }



    @Override
    public int getItemCount() {
        return mAnimeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView mTitle,mDescription,mRating,mStudio,mCategories;
        private ImageView mAnimeThumbnail;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.tv_title);
            mStudio = itemView.findViewById(R.id.tv_studio);
            mRating = itemView.findViewById(R.id.tv_rating);
            mCategories = itemView.findViewById(R.id.tv_categories);
            mAnimeThumbnail = itemView.findViewById(R.id.thumbnail);


        }
    }

}
