package Lab5;
import java.util.Arrays;

public class Lab5_650147 {
    static int[] data = {28, 58, 8, 77, 48, 39};
    static ArrayProcessor q1NumberOfEvenElement;
    static ArrayProcessor q2IndexOfLargestEvenValue;
    static ArrayProcessor myMedian;

    public static void main(String[] args) {
        q1();
        q2();
        oneline();
    }

    static void q1() {
        q1NumberOfEvenElement = (data) -> {
            int ans = 0;

            for (int i = 0; i < data.length; i++)
                if (data[i] % 2 == 0)
                    ans += 1;
            return (ans);
        };
        System.out.println(q1NumberOfEvenElement.calculate(data));
    }

    static void q2() {
        q2IndexOfLargestEvenValue = (data) -> {
            int ans = 0;

            for (int i = 0; i < data.length; i++)
                if (data[i] > data[ans])
                    if (data[i] % 2 == 0)
                        ans = i;
            return (ans);
        };
        System.out.println(q2IndexOfLargestEvenValue.calculate(data));
    }

    static void oneline() {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        myMedian = (data) -> (int)(data[data.length / 2]);
        System.out.println(myMedian.calculate(tmp));
    }
}
