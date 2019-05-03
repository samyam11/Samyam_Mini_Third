package com.example.ushan_mini_third;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AddItemsActivity extends AppCompatActivity {
    EditText etItemName, etItemPrice, etItemImageName, etItemDescription;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        etItemName = findViewById(R.id.etItemName);
        etItemPrice = findViewById(R.id.etItemPrice);
        etItemImageName = findViewById(R.id.etItemImageName);
        etItemDescription = findViewById(R.id.etItemDescription);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();

            }
        });
    }

    private void Save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("text.txt",MODE_PRIVATE|MODE_APPEND));
            printStream.println(etItemName.getText().toString()+"->"+etItemPrice.getText().toString()+"->"
                    +etItemImageName.getText().toString()+"->"+etItemDescription.getText().toString());
            etItemName.setText("");
            etItemPrice.setText("");
            etItemImageName.setText("");
            etItemDescription.setText("");

            Toast.makeText(AddItemsActivity.this, "Saved to" +getFilesDir(),Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            Log.d("Item Add","Error"+e.toString());
            e.printStackTrace();
        }
    }
}
