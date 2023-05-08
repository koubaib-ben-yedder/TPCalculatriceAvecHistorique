package com.example.tpcalculatriceavechistorique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AdaptateurNombre extends ArrayAdapter<Card_View> {
    public AdaptateurNombre(@NonNull Context context, ArrayList<Card_View> nombres) {
        super(context, 0,nombres);
    }
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View card_view = convertView;
        if(card_view == null){
            card_view = LayoutInflater.from(getContext()).inflate(R.layout.card_view,parent,false);
        }
        Card_View nombreCourant = getItem(position);
        TextView txt_value = (TextView) card_view.findViewById(R.id.txt_value);
        txt_value.setText(nombreCourant.getValue());

        TextView txt_equation = (TextView) card_view.findViewById(R.id.txt_equation);
        txt_equation.setText(nombreCourant.getEquation());



        return card_view;
    }

}
