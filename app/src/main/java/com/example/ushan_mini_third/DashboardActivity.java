package com.example.ushan_mini_third;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import adapter.ItemAdapter;
import model.Item;
import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerView);

        Toast.makeText(DashboardActivity.this, "LOL",Toast.LENGTH_LONG).show();
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("White",500,R.drawable.ic_launcher_foreground,"White Shirt."));


      ItemAdapter itemAdapter = new ItemAdapter(DashboardActivity.this, itemList);
      recyclerView.setAdapter(itemAdapter);
      recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

}
