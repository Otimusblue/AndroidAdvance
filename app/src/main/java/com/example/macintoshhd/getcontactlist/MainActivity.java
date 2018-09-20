package com.example.macintoshhd.getcontactlist;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import static android.provider.ContactsContract.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "GET_CONTACT";
    private Button mButtonGet;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPermission();


        mButtonGet = findViewById(R.id.btn_get_contact);
        mButtonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContactList();
            }
        });
        mListView = findViewById(R.id.list_view);
    }
    //Get contact
    private void getContactList() {
        Cursor cursor = getContentResolver().query(CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        String[] from = { CommonDataKinds.Phone.DISPLAY_NAME,CommonDataKinds.Phone.NUMBER,CommonDataKinds.Phone._ID};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,cursor,from,to);
        mListView.setAdapter(simpleCursorAdapter);
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        
    }
    public void initPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

                //Register permission
                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 1);
            }
        }
    }

}
