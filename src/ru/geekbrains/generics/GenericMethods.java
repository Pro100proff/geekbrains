package ru.geekbrains.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericMethods {

    public static <T> T coalesce(T... elements){
        for (T e: elements
             ) {
            if(e != null){
                return e;
            }
        }
        return null;
    }


    public static <T, U> List<U> convertList(List<T> originList, Function<T, U> mapFunction){
        List<U> newList = new ArrayList<>();
        for (T element: originList
             ) {
            newList.add(mapFunction.apply(element));
        }
        return newList;
    }


}
