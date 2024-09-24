package com.maxime.calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int add(int opG, int opD){
        return opG + opD;
    } ;

    public int divide(int opG, int opD){
        return opG / opD;
    } ;

    public Set<Integer> ensembleChiffres(int pNombre) {
        Set<Integer> chiffres = new HashSet<>();
        String nombreStr = String.valueOf(Math.abs(pNombre));

        for (char c : nombreStr.toCharArray()) {
            chiffres.add(Character.getNumericValue(c));
        }

        return chiffres;
    }
}
