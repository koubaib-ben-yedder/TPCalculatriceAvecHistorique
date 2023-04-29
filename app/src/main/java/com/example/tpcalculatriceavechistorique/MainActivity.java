package com.example.tpcalculatriceavechistorique;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import  com.example.tpcalculatriceavechistorique.Card_Model;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCards = (ListView) findViewById(R.id.list);
        Cards_Adapter adapter = new Cards_Adapter(this);

        lvCards.setAdapter(adapter);
        adapter.addAll(

                new Card_Model("-","-"),
                new Card_Model("-","-"),
                new Card_Model("-","-"),
                new Card_Model("-","-")

                );


    }
}