package com.example.tpcalculatriceavechistorique;
public class Card_View {
    private  String equation;
    private  String value;

    public Card_View (String equation, String value){


        this.equation = equation;
        this.value = value;
    }
    public String getEquation() {
        return equation;
    }

    public String getValue() {
        return value;
    }

    public void setEquation (String equation) {
        this.equation = equation;
    }

    public void setValue (String value) {
        this.value = value;
    }




}