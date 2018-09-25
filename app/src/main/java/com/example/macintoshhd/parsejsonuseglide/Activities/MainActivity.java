package com.example.macintoshhd.parsejsonuseglide.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.macintoshhd.parsejsonuseglide.Adapter.MovieAdapter;
import com.example.macintoshhd.parsejsonuseglide.Model.Anime;
import com.example.macintoshhd.parsejsonuseglide.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private JsonArrayRequest mJsonArrayRequest;
    private RequestQueue mRequestQueue;
    private String URL_JSON ="https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private RecyclerView mRecyclerView;
    private List<Anime> mAnimes = new ArrayList<>();
    private MovieAdapter mDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JsonCall();
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv_layout);
        mDataAdapter = new MovieAdapter(this);
        mRecyclerView.setAdapter(mDataAdapter);


    }

    private void JsonCall() {
        mJsonArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        Anime anime = new Anime();

                        anime.setName(jsonObject.getString("name"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setCategories(jsonObject.getString("categorie"));
                        anime.setImage(jsonObject.getString("img"));

                        mAnimes.add(anime);
                        //set adapter


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                mDataAdapter.updateDate(mAnimes);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

    });

        mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        mRequestQueue.add(mJsonArrayRequest);


    }
}
