package com.example.ushan_mini_third;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import adapter.ItemAdapter;
import model.Item;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Item> itemValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerView);
        itemValue = new ArrayList<>();


        readFromFile();

//        Toast.makeText(DashboardActivity.this, "LOL", Toast.LENGTH_LONG).show();
//        List<Item> itemList = new ArrayList<>();
//        String itemName, itemDescription;
//        Integer itemPrice, itemImageName;
//        itemName = itemValue.get(1);
//        itemPrice = Integer.valueOf(itemValue.get(2));
//        itemImageName = getResources().getIdentifier("@drawable/" + itemValue.get(2), null, this.getPackageName());
//        itemDescription = itemValue.get(3);
//
//        Toast.makeText(DashboardActivity.this, itemName + " " + itemPrice + " " + itemImageName + " " + itemDescription, Toast.LENGTH_LONG).show();


        //itemList.add(new Item(itemName, itemPrice, itemImageName, itemDescription));
        itemValue.add(new Item("Black Coat", 500, R.drawable.a, "This is a black coat."));


        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), itemValue);
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
//                for (int i =0; i<4;i++){
//
//                itemValue.add(parts[i]);
//                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}