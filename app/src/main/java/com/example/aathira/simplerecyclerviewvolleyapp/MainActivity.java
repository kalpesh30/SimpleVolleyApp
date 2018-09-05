package com.example.aathira.simplerecyclerviewvolleyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    private String BASE_URL = "https://api.github.com/users" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_1) ;
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        StringRequest request = new StringRequest(BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Users[] users = gson.fromJson(response,Users[].class) ;
                CustAdapter mAdapter = new CustAdapter(getBaseContext(),users) ;
                recyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("JSON error","Data not received") ;
            }
        }) ;
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request) ;


    }
}
