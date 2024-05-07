package ru.stroganov.spring.myArrayList.exception;

import ru.stroganov.spring.myArrayList.MyArrayList;
import ru.stroganov.spring.myArrayList.StringList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new MyArrayList();
        stringList.add("5");
        stringList.add("6");
        stringList.add("7");
        stringList.add("8");
        stringList.add("9");
        stringList.add("10");
        stringList.remove(3);
        String[] strings = stringList.toArray();
        System.out.println(Arrays.toString(strings));
    }
}
