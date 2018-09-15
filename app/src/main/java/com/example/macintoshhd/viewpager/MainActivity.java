package com.example.macintoshhd.viewpager;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataFrog> mDataFrogs;
    private DataAdapter mDataAdapter;
    private ViewPager mViewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

    }

    private void initData() {
        mDataFrogs = new ArrayList<>();

        mDataFrogs.add(new DataFrog("#FF3F52C9",R.drawable.ech_1,"Ech buon"));
        mDataFrogs.add(new DataFrog("#FFFF4081",R.drawable.ech_2,"Ech co don"));
        mDataFrogs.add(new DataFrog("#FF303F9F",R.drawable.ech_3,"Ech cam sung"));
        mDataFrogs.add(new DataFrog("#FF23FF20",R.drawable.ech_2,"Ech buon"));

    }

    private void initView() {
        mViewPager = findViewById(R.id.view_pager);
        mDataAdapter = new DataAdapter(this,mDataFrogs);

        mViewPager.setAdapter(mDataAdapter);
    }
}
