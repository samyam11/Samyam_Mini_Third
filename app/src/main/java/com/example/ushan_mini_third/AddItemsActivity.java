package com.example.ushan_mini_third;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class AddItemsActivity extends AppCompatActivity {
    EditText etItemName, etItemPrice, etItemImageName, etItemDescription;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        etItemName = findViewById(R.id.etItemName1);
        etItemPrice = findViewById(R.id.etItemPrice1);
        etItemImageName = findViewById(R.id.etItemImageName1);
        etItemDescription = findViewById(R.id.etItemDescription1);
        btnAdd = findViewById(R.id.btnAdd1);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();

            }
        });
    }

    public void addItem() {
        try {
            PrintStream printStream=new PrintStream(openFileOutput("items.txt",MODE_PRIVATE |MODE_APPEND));
            printStream.println(etItemName.getText().toString() + "->"+etItemPrice.getText().toString()
                    + "->"+etItemImageName.getText().toString()+"->"+etItemDescription.getText().toString());
            Toast.makeText(this, "saved to"+getFilesDir(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Log.d("Item Add","error:"+e.toString());
            e.printStackTrace();
        }
    }

}
