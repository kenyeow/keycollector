package com.keycollector;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Yeow Wan Shung
 * A util class to generate random number with specified range and
 *  add random number with limited range to an array list
 * **/
public final class RandomNumberUtils {

    private final static Random random = new Random();

    public static int generateRandomNumber(int range){
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
