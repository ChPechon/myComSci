package Lab8b;

import java.util.Arrays;

public class MergeSort_65050147 {
    static void m_sort(int [] input, int pass) {
        int size = input.length;
        if (size > 1) {
            int mid = input.length / 2;
            int[] left = new int[mid];
            int[] right = new int[size - mid];
            pass++;

            for (int i = 0; i < mid; i++)
                left[i] = input[i];
            
            int remainSize = right.length;
            for (int j = 0; j < remainSize; j++)
                right[j] = input[j + mid];

            m_sort(left, pass);
            m_sort(right, pass);
            merge(input, left, right);
            System.out.println(pass + " " + size);
        }
    }

    static void merge(int [] input, int [] left, int [] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0;
        int j = 0;
        int k = 0;

        while((i < leftSize) && (j < rightSize)) {
            if (left[i] <= right[j])
                input[k++] = left[i++];
            else
                input[k++] = right[j++];
        }

        if (i == leftSize)
            while (j < rightSize)
                input[k++] = right[j++];
        else
            while (i < leftSize)
                input[k++] = left[i++];
    }

    static void m_sort(int[][] input, int pass) {
        int size = input.length;
        if (size > 1) {
            int mid = input.length / 2;
            int[][] left = new int[mid][input[0].length];
            int[][] right = new int[size - mid][input[0].length];
            pass++;

            for (int i = 0; i < mid; i++)
                left[i] = input[i].clone();

            int size2 = right.length;
            for (int j = 0; j < size2; j++)
                right[j] = input[j + mid].clone();

            System.out.printf("pass %d %s%n", pass, Arrays.deepToString(left));
            System.out.printf("pass %d %s%n", pass, Arrays.deepToString(right));

            m_sort(left, pass);
            m_sort(right, pass);
            merge(input, left, right);
        }
    }

    static void merge(int[][] input, int[][] left, int[][] right) {
        int p = left.length;
        int q = right.length;
        int i = 0, j = 0, k = 0;
        while ((i < p) && (j < q)) {
            if (left[i][0] > right[j][0])
                input[k++] = left[i++];
            else
                input[k++] = right[j++];
        }
        if (i == p)
            while (j < q)
                input[k++] = right[j++];
        else
            while (i < p)
                input[k++] = left[i++];
    }

    static void m_sort(int[][] input, int key1, int key2, int pass) {
        int size = input.length;
        if (size > 1) {
            int mid = input.length / 2;
            int[][] left = new int[mid][input[0].length];
            int[][] right = new int[size - mid][input[0].length];
            pass++;

            for (int i = 0; i < mid; i++)
                left[i] = input[i].clone();

            int size2 = right.length;
            for (int j = 0; j < size2; j++)
                right[j] = input[j + mid].clone();

            System.out.printf("pass %d %s%n", pass, Arrays.deepToString(left));
            System.out.printf("pass %d %s%n", pass, Arrays.deepToString(right));

            m_sort(left, key1, key2, pass);
            m_sort(right, key1, key2, pass);
            merge(input, left, right, key1, key2);
        }
    }

    static void merge(int[][] input, int[][] left, int[][] right, int key1, int key2) {
        int p = left.length;
        int q = right.length;
        int i = 0, j = 0, k = 0;
        
        while ((i < p) && (j < q)) {
            if (left[i][key1] != right[j][key1])
                if (left[i][key1] > right[j][key1])
                    input[k++] = left[i++];
                else
                    input[k++] = right[j++];
            else
                if (left[i][key2] > right[j][key2])
                    input[k++] = left[i++];
                else
                    input[k++] = right[j++];
        }
        if (i == p)
            while (j < q)
                input[k++] = right[j++];
        else
            while (i < p)
                input[k++] = left[i++];
    }
}
