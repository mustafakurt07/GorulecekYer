package com.example.landmarks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
        final ArrayList<String>landing=new ArrayList<>();
        landing.add("Sultan Ahmet");
        landing.add("Pisa");
        //landing.add("Colesseum");
        landing.add("Damn Sequare");
        final ArrayList<String>countryNames=new ArrayList<>();
        countryNames.add("Turkey");
        countryNames.add("Italy");
        //countryNames.add("Italy");
        countryNames.add("Amsterdam");
        Bitmap sultan= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.sultanahmet);
        Bitmap pisa= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
       // Bitmap colesseum= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colesseum);
        Bitmap damn= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.damn);
        final ArrayList<Bitmap> gorsel=new ArrayList<>();
        gorsel.add(sultan);
        gorsel.add(pisa);
        //gorsel.add(colesseum);
        gorsel.add(damn);



        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_expandable_list_item_1,landing);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),DetailsActivity.class);
                intent.putExtra("name",landing.get(position));
                intent.putExtra("country",countryNames.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(gorsel.get(position));
                startActivity(intent);
            }
        });/*rowa tıklandıgında ne yapacagını belırten metot*/

    }
}
