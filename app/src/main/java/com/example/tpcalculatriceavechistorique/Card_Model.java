package com.example.tpcalculatriceavechistorique;

/**
 * @author Alhaytham Alfeel on 10/10/2016.
 */

public class Card_Model {
    private String value;
    private String equation;

    public Card_Model(String value, String equation) {
        this.value = value;
        this.equation = equation ;
    }

    public String getValue() {
        return value;
    }

    public String getEquation() {
        return equation;
    }


}
