package arrays.medium;

import java.util.Arrays;

public class NextPermutation {

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static int[] solution_1(int[] arr, int n) {
        int breakpoint = n - 2;
        while (breakpoint >= 0 && arr[breakpoint] >= arr[breakpoint + 1]) {
            breakpoint--;
        }
        if (breakpoint == -1) {
            NextPermutation.reverse(arr, 0, n - 1);
            return arr;
        }
        for (int i = n - 1; i > breakpoint; i--) {
            if (arr[i] > arr[breakpoint]) {
                int temp = arr[i];
                arr[i] = arr[breakpoint];
                arr[breakpoint] = temp;
                break;
            }
        }
        NextPermutation.reverse(arr, breakpoint + 1, n - 1);
        return arr;
    }

    public static void test(int[] input, int[] expected) {
        int[] result = NextPermutation.solution_1(input, input.length);
        if (Arrays.equals(result, expected)) {
            System.out.println("✅ Passed: " + Arrays.toString(result));
        } else {
            System.out.println("❌ Failed: expected " + Arrays.toString(expected) + ", got " + Arrays.toString(result));
        }
    }

    public static void main(String[] args) {
        test(new int[]{2, 1, 5, 4, 3, 0, 0}, new int[]{2, 3, 0, 0, 1, 4, 5});
        test(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5});
        test(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        test(new int[]{1, 1, 5}, new int[]{1, 5, 1});
        test(new int[]{7, 7, 7}, new int[]{7, 7, 7});
        test(new int[]{1, 3, 2}, new int[]{2, 1, 3});
    }

}