package Lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lab8 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    static void task1() {
        System.out.println("-demo1---");
        SillyLuckyNumber[] arr = {
                new SillyLuckyNumber("Terrier"),
                new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"),
                new SillyLuckyNumber("Beagle"),
                new SillyLuckyNumber("Jessica"),
        };
        System.out.println(Arrays.toString(arr));
        Comparator<SillyLuckyNumber> engine = Comparator.comparing(SillyLuckyNumber::getLuckyNumber);
        Arrays.sort(arr, engine);
        System.out.println(Arrays.toString(arr));
    }

    static void task2() {
        System.out.println("-demo2----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(
                Arrays.asList(
                        new SillyLuckyNumber("Terrier"),
                        new SillyLuckyNumber("Jack"),
                        new SillyLuckyNumber("Pom"),
                        new SillyLuckyNumber("Beagle")));
        System.out.println(list);
        Collections.sort(list, Comparator.comparing(SillyLuckyNumber::getLuckyNumber));
        System.out.println(list);
    }

    static void task3() {
        System.out.println("-demo3----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
                new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
        System.out.println(list);
        list.sort(Comparator.comparing(SillyLuckyNumber::getLuckyNumber));
        System.out.println(list);
        ArrayList<SillyLuckyNumber> anotherList = new ArrayList<>(list.subList(0, list.size()));
        anotherList.get(0).setBreed("newBreed");
        System.out.println(list);
    }

    static void task4() {
        System.out.println("-demo4----");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        System.out.println(arr);
        arr.swap(1, 3);
        System.out.println(arr);
    }

    static void task5() {
        System.out.println("-demo5----");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        arr.add(new SillyLuckyNumber("Cocker Spaniel"));
        arr.add(new SillyLuckyNumber("Basenji"));
        System.out.println(arr);
        selectionSort(arr);
        System.out.println(arr);
    }

    static void selectionSort(MyArrDemo<SillyLuckyNumber> arr) {
        int smallestIndex;
        for (int j = 0; j < arr.currentSize() - 1; j++) {
            smallestIndex = j;
            for (int i = j; i < arr.currentSize(); i++)
                if (arr.get(i).getLuckyNumber() < arr.get(smallestIndex).getLuckyNumber())
                    smallestIndex = i;
            arr.swap(j, smallestIndex);
        }
    }
}
