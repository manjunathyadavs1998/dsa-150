package com.dsa.top.dsa_problems.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FailFastSafe {

    public static int count=-1;


    public static void main(String[] args) {
        List<Integer> input= new ArrayList<>();
        input.add(10);
        input.add(20);
        input.add(30);
        Iterator<Integer>iterator=input.iterator();
        while (iterator.hasNext()){
            input.add(70);
            Integer next=iterator.next();

        }


    }
}
