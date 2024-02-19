package Lab8;

import java.util.Arrays;

public class ex0 {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        System.out.println("-ex0---");
        int[] arr = { 7, 3, 1, 9, 6, 8, 4, 2, 5 };
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
