package ru.geekbrains.generics;

import java.util.ArrayList;
import java.util.List;

public class NewWayGeneric {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("empty string");
        strings.add("another empty string");
        showStrings(strings);
    }

    public static void showStrings(List<String> strings){
        for (int i = 0; i<= strings.size()-1; i++){
            String str = strings.get(i);
            System.out.println(str.toUpperCase());
        }
    }
}
