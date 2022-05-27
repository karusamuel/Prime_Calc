package com.example.primecalc.primecalculator;

import java.util.ArrayList;

public class PrimeCalculator {


    public ArrayList<Integer> calculatePrime(Integer startInt,Integer endInt){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = startInt;i <= endInt;i++){
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;

    }

    public boolean isPrime(Integer num){
        boolean flag = true;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
