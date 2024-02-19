package Lab8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class Lab8Main {
    public static void main(String[] args) {
        q1();
    }

    public static void q1() {
        List<Integer> nums = Arrays.asList(100, 105);

        HalfValueInterface halfVal = (n) -> System.out.println(n / 2);
        for (int n : nums) {
            halfVal.printHalf(n);
        }

        Consumer<Integer> consumer = (n) -> System.out.println(n / 2);
        for (int n : nums) {
            consumer.accept(n);
        }

        Consumer<Integer> halfMe = (n) -> System.out.println(n / 2);
        nums.forEach(halfMe);

        nums.forEach(halfMe = (n) -> System.out.println(n / 2));

        NumberProcessor np = new NumberProcessor();
        nums.forEach(np::printHalf);
    }

    public static void q2_forEachSingerName() {
        List
        singerList.stream().map(/* q2.1 */).forEach(System.out::println);
        singerList.stream().map(/* q2.2 */).forEach(System.out::println);
        }
}

class NumberProcessor {
    public void printHalf(int n) {
        System.out.println(n / 2);
    }
}
