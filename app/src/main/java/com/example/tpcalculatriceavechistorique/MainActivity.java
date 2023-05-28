package com.example.tpcalculatriceavechistorique;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    AdaptateurNombre adapater;
    TextView txt_value;

    ListView listView;
    TextView txt_equation;
    Button btn_7;
    Button btn_6;
    Button btn_5;
    Button btn_8;
    Button btn_9;
    Button btn_4;
    Button btn_3;
    Button btn_2;
    Button btn_1;
    Button btn_eqaul;
    Button btn_add;
    Button btn_point;
    Button btn_0;
    Button btn_ac;
    Button btn_power;
    Button btn_div;
    Button btn_back;
    Button btn_sub;

    SQLiteDatabase bd;


    String value;

    String equation;

    String ope;

    String num1, num2;

    public void Database_Setup(String Data_Base_Name) {

        bd = openOrCreateDatabase("" + Data_Base_Name + "", Context.MODE_PRIVATE, null);


    }

    public void Create_Opeation_Table() {

        bd.execSQL("CREATE TABLE IF NOT EXISTS operation (id integer primary key autoincrement,value VARCHAR,ope VARCHAR,num1 Varchar,num2 Varchar);");

    }

    public void Insert_Operation_Table(String value, String ope, String num1, String num2) {


        bd.execSQL("INSERT INTO operation (ope,value,num1,num2) VALUES ('" + ope + "'" + "," + value + "," + num1 + "," + num2 + ");");

    }


    public  ListView Select_Operation_Table() {

        ArrayList<Card_View> card_views = new ArrayList<Card_View>();


        Cursor c = bd.rawQuery("SELECT value,ope,num1,num2 FROM operation", null);


        if (c.moveToLast()) {
            do {


                value = c.getString(0);
                ope = c.getString(1);
                num1 = c.getString(2);
                num2 = c.getString(3);


                if (ope.equals("divide")) {

                    card_views.add(new Card_View(num1+" "+"/"+" "+num2,""+value+""));

                } else if (ope.equals("multiply")) {

                    card_views.add(new Card_View(num1+" "+"*"+" "+num2, ""+value+""));


                } else if (ope.equals("substract")) {

                    card_views.add(new Card_View(num1+" "+"-"+" "+num2,""+value+""));

                } else {

                    card_views.add(new Card_View(num1+" "+"+"+" "+num2,""+value+""));

                    }



            } while (c.moveToPrevious());
        }

        adapater = new AdaptateurNombre(this, card_views);

        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapater);
        listView.smoothScrollToPosition(5);

        return listView;


}



    public void calculer (ArrayList<String>list) {

        String aux = "";



        double cal = 0;


        for (int i = 0; i < list.size(); i++) {

            aux = aux + list.get(i);

            if (list.get(i) == "/") {

                ope="/";

            } else if (list.get(i) == "*") {

                ope="*";


            } else if (list.get(i) == "-") {

                ope="-";

            } else if (list.get(i) == "+") {

                ope="+";

            }


        }


        num1 = aux.substring(0, aux.indexOf(ope));

        num2 = aux.substring(aux.indexOf(ope) + 1, aux.length());

        if (ope == "/") {

            ope="divide";
            cal = Double.parseDouble(num1) / Double.parseDouble(num2);


        } else if (ope == "*") {

            ope="multiply";

            cal = Double.parseDouble(num1) * Double.parseDouble(num2);

        } else if (ope == "-") {

            ope="substract";

            cal = Double.parseDouble(num1) - Double.parseDouble(num2);

        } else {
            ope="add";

            cal = Double.parseDouble(num1) + Double.parseDouble(num2);

        }


        txt_value.setText(String.valueOf(cal));


        value = String.valueOf(cal);







    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0=(Button) findViewById(R.id.btn_0);
        btn_1=(Button) findViewById(R.id.btn_1);
        btn_2=(Button) findViewById(R.id.btn_2);
        btn_3=(Button) findViewById(R.id.btn_3);
        btn_4=(Button) findViewById(R.id.btn_4);
        btn_5=(Button) findViewById(R.id.btn_5);
        btn_6=(Button) findViewById(R.id.btn_6);
        btn_7=(Button) findViewById(R.id.btn_7);
        btn_8=(Button) findViewById(R.id.btn_8);
        btn_9=(Button) findViewById(R.id.btn_9);
        btn_back=(Button) findViewById(R.id.btn_back);
        btn_div=(Button) findViewById(R.id.btn_div);
        btn_ac=(Button) findViewById(R.id.btn_ac);
        btn_eqaul=(Button) findViewById(R.id.btn_eqaul);
        btn_add=(Button) findViewById(R.id.btn_add);
        btn_point=(Button) findViewById(R.id.btn_point);
        btn_sub=(Button) findViewById(R.id.btn_sub);
        btn_power=(Button) findViewById(R.id.btn_power);
        txt_equation= (TextView) findViewById(R.id.txt_equation);
        txt_value= (TextView) findViewById(R.id.txt_value);
        ArrayList<String> list = new ArrayList<String>();




       btn_0.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


            list.add("0");
             String aux="";

               for (int i = 0; i< list.size(); i++){

                   aux=aux+ list.get(i);

               }

               txt_equation.setText(aux);


           }
       });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("1");

                String aux="";

                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("2");
                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);

            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("3");
                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);

            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("4");
                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);

            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("5");
                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);

            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("6");
                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);

            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("7");
                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);

            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("8");
                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);

            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("9");

                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (list.size()>=1){

                    String aux="";
                    list.remove(list.size()-1);

                    for (int i = 0; i< list.size(); i++){

                        aux=aux+ list.get(i);

                    }

                    if (list.size() == 0) {
                        txt_equation.setText("0");
                    }else{
                        txt_equation.setText(aux);

                }


                    aux="";

                }





            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               list.removeAll(list);

                txt_equation.setText("0");

                txt_value.setText("0");



            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("+");
                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);


            }
        });

        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add(".");

                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("/");
                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);

            }
        });
        // app

        btn_eqaul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                calculer(list);



               Create_Opeation_Table();

               Insert_Operation_Table(value,ope,num1,num2);

               Select_Operation_Table();




            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("-");
                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);

            }
        });

        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                list.add("*");

                String aux="";
                for (int i = 0; i< list.size(); i++){

                    aux=aux+ list.get(i);

                }

                txt_equation.setText(aux);
            }
        });





            Database_Setup("cal");

            Select_Operation_Table();






    }
}