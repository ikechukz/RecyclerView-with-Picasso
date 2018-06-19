package com.example.android.recycledimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private final String image_urls[] = {
            "https://source.unsplash.com/collection/1237/400x400",
            "https://source.unsplash.com/collection/190727/400x400",
            "https://source.unsplash.com/collection/1238/400x400",
            "https://source.unsplash.com/collection/1239/400x400",
            "https://source.unsplash.com/collection/1231/400x400",
            "https://source.unsplash.com/collection/1232/400x400",
            "https://source.unsplash.com/collection/1233/400x400",
            "https://source.unsplash.com/collection/1234/400x400"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        //initialise recyclerView and setLayoutManager to recyclerViewa
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        //prepare ArrayList to be passed to adapter
        ArrayList androidVersions = prepareData();
        //initialise adapter and setAdapter to recyclerView
        LogoAdapter adapter = new LogoAdapter(getApplicationContext(), androidVersions);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList prepareData() {
        ArrayList imageList = new ArrayList<>();
        for (int i = 0; i < image_urls.length; i++) {
            Logo logo = new Logo();
            logo.setLogo_image_link(image_urls[i]);
            imageList.add(logo);
        }
        return imageList;
    }
}