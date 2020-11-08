package ru.geekbrains.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardMethods {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(12);
        integers.add(121);
        System.out.println(getSumElements(integers));

        List<Double> doubles = new ArrayList<>();
        doubles.add(1.0);
        doubles.add(12.0);
        doubles.add(121.0);
        System.out.println(getSumElements(doubles));

        List<Number> numbers = new ArrayList<>();
        addNewElements(numbers);
        System.out.println(getSumElements(numbers));
    }

    public static int getSumElements(List<? extends Number> numbers){
        int sum = 0;
        for (Number n: numbers
        ) {
            sum+=n.intValue();
        }
        return sum;
    }

    public static void addNewElements(List<? super Number> numbers){
        numbers.add(11);
        numbers.add(11f);
        numbers.add(133);
        numbers.add(12d);
    }
}
