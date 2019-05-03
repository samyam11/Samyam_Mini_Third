package com.example.ushan_mini_third;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AfterLoginActivity extends AppCompatActivity {

    private Button btnAddItems, btnDashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        btnAddItems= findViewById(R.id.btnAddItems);
        btnDashboard = findViewById(R.id.btnDashboard);

        btnAddItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(AfterLoginActivity.this, AddItemsActivity.class);
                startActivity(addIntent);
            }
        });

        btnDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboardIntent= new Intent(AfterLoginActivity.this, DashboardActivity.class );
                startActivity(dashboardIntent);
            }
        });
    }
    }

