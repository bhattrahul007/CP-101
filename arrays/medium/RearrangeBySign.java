package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeBySign {

    /**
     * Best solution when positives and negatives are not guaranteed to be equal in number
     *
     * @param arr
     * @param n
     * @return
     */
    public static int[] solution_1(int[] arr, int n) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int i : arr) {
            if (i < 0) negatives.add(i);
            else positives.add(i);
        }
        int i = 0;
        for (i = 0; i < Math.min(positives.size(), negatives.size()); i++) {
            arr[2 * i] = positives.get(i);
            arr[2 * i + 1] = negatives.get(i);
        }
        int index = 2 * i;
        while (i < positives.size())
            arr[index++] = positives.get(i++);
        while (i < negatives.size())
            arr[index++] = negatives.get(i++);
        return arr;
    }

    /**
     * Solution when we know that positives and negatives are equal.
     *
     * @param input
     * @param n
     * @return
     */
    public static int[] solution_2(int[] arr, int n) {
        int[] result = new int[n];
        int positives = 0, negatives = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                arr[negatives] = arr[i];
                negatives += 2;
            } else {
                arr[positives] = arr[i];
                positives += 2;
            }
        }
        return result;
    }

    public static void test(int[] input, int[] expected) {
        int[] result = RearrangeBySign.solution_1(input, input.length);
        if (Arrays.equals(result, expected)) {
            System.out.println("✅ Passed: " + Arrays.toString(result));
        } else {
            System.out.println("❌ Failed: expected " + Arrays.toString(expected) + ", got " + Arrays.toString(result));
        }
    }

    public static void main(String[] args) {
        test(new int[]{3, 1, -2, -5, 2, -4}, new int[]{3, -2, 1, -5, 2, -4});
        test(new int[]{3, 1, -2, -5, 2, -4, 8, 4, 23, 1}, new int[]{3, -2, 1, -5, 2, -4, 8, 4, 23, 1});
        test(new int[]{3, 1, -2, -5, 2, -4, -8, -4, -24, -1}, new int[]{3, -2, 1, -5, 2, -4, -8, -4, -24, -1});
        test(new int[]{1, 2}, new int[]{1, 2});
        test(new int[]{-1}, new int[]{-1});
    }
}
