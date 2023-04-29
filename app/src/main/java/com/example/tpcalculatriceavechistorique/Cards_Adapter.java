package com.example.tpcalculatriceavechistorique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tpcalculatriceavechistorique.R;
import com.example.tpcalculatriceavechistorique.Card_Model;
/**
 * @author Alhaytham Alfeel on 10/10/2016.
 */

public class Cards_Adapter extends ArrayAdapter<Card_Model> {
    public Cards_Adapter(Context context) {
        super(context, R.layout.card_view);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.card_view, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Card_Model model = getItem(position);

        holder.value.setText(model.getValue());
        holder.equation.setText(model.getEquation());

        return convertView;
    }

    static class ViewHolder {
        TextView value;
        TextView equation;

        ViewHolder(View view) {
            value = (TextView) view.findViewById(R.id.txt_value);
            equation = (TextView) view.findViewById(R.id.txt_equation);
        }
    }
}

