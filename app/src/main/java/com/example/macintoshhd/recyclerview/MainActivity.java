package com.example.macintoshhd.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        List<DataModel> listDataModel = new ArrayList<>();
        listDataModel.add(new DataModel(R.drawable.iphone,getApplicationContext().getString(R.string.branch)));
        listDataModel.add(new DataModel(R.drawable.samsung ,"Samsung"));
        listDataModel.add(new DataModel(R.drawable.oppo,"Oppo"));
        listDataModel.add(new DataModel(R.drawable.sony,"Sony"));

        DataAdapter dataAdapter = new DataAdapter(listDataModel);
        recyclerView.setAdapter(dataAdapter);

    }
}
