package com.example.landmarks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
ImageView ımageView;
TextView name,country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ımageView=findViewById(R.id.imageView);
        name=findViewById(R.id.textView);
        country=findViewById(R.id.textView2);
        Intent intent=getIntent();
        String ad=intent.getStringExtra("name");
        String sehir=intent.getStringExtra("country");
        name.setText(ad);
        country.setText(sehir);
        Singleton singleton=Singleton.getInstance();
        ımageView.setImageBitmap(singleton.getChosenImage());



    }
}
