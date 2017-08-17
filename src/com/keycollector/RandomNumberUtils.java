package com.keycollector;

import java.util.ArrayList;
import java.util.Random;

/**
 * A util class to generate random number with specified range and
 *  add random number with limited range to an array list
 * **/
public final class RandomNumberUtils {

    public static int generateRandomNumber(int range){
        Random random = new Random();
        return random.nextInt(range) + 1;
    }

    public static ArrayList<Integer> addRandomNumberToArrayList(ArrayList<Integer> list, int range, int max){
        while(list.size() <= max){
            int randomNumber = generateRandomNumber(range);
            if(!list.contains(randomNumber)){
                list.add(randomNumber);
            }
        }

        return list;
    }
}
