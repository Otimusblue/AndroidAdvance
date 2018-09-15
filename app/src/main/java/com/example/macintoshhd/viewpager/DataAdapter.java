package com.example.macintoshhd.viewpager;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class DataAdapter extends PagerAdapter {

    private ArrayList<DataFrog> mDataFrogs;
    private LayoutInflater mInflater;


    public DataAdapter(Context context,ArrayList<DataFrog> dataFrogs) {
        mDataFrogs = dataFrogs;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mDataFrogs.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //Tranform XML to View
        View view = mInflater.inflate(R.layout.item_layout,container,false);

        //Reference View(Button,TextView,BackGround,....)
        LinearLayout lnContainer = view.findViewById(R.id.ln_container);
        ImageView imageEch = view.findViewById(R.id.img_ech);
        TextView tvEch = view.findViewById(R.id.tv_ech);

        //Way to Get Data
        DataFrog eachFrog = mDataFrogs.get(position);
        lnContainer.setBackgroundColor(Color.parseColor(eachFrog.getBackGroundColor()));
        imageEch.setImageResource(eachFrog.getIdImage());
        tvEch.setText(eachFrog.getDescription());
        //Set View to Container
        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
         container.removeView((View) object);
    }
}
