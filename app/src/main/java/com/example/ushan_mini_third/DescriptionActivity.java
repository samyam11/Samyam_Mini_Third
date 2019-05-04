package com.example.ushan_mini_third;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DescriptionActivity extends AppCompatActivity {
    private CircleImageView imgItem;
    private TextView tvName, tvPrice, tvDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        imgItem = findViewById(R.id.imgItem);
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        tvDescription = findViewById(R.id.tvDescription);

        Bundle bundle = getIntent().getExtras();

        imgItem.setImageResource(bundle.getInt("image"));
        tvName.setText(bundle.getString("name"));
        tvPrice.setText(Integer.toString(bundle.getInt("price")));
        tvDescription.setText(bundle.getString("description"));


    }
}
