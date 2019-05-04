package com.example.ushan_mini_third;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import adapter.ItemAdapter;
import model.Item;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Item> itemValue = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerView);

        readFromFile();

        final ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), itemValue);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }


    private void readFromFile() {
        try {
            FileInputStream fis = openFileInput("items.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("->");
                String imgDrawable = parts[2];
                int price = Integer.parseInt(parts[1]);
                int id = getResources().getIdentifier(imgDrawable,"drawable",getPackageName());
                itemValue.add(new Item(parts[0],price,id,parts[3]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}