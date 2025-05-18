package arrays.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
 * has the largest sum and returns its sum and prints the subarray.
 * <p>
 * Examples
 * Example 1:
 * <p>
 * Input: arr = [-2,1,-3,4,-1,2,1,-5,4]
 * <p>
 * Output: 6
 * <p>
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Examples 2:
 * <p>
 * Input: arr = [1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Array has only one element and which is giving positive sum of 1.
 */
public class MaximumSumSubarray {
    public static int[] solution_1(int[] arr, int n) {
        int max = 0, start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > max) {
                    max = sum;
                    start = i;
                    end = j;
                }
            }
        }
        return IntStream.of(max, start, end).toArray();
    }

    public static int[] solution_2(int[] arr, int n) {
        int start = -1, end = -1, tempStart = -1;
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (sum == 0) tempStart = i;
            sum += arr[i];
            if (sum > max) {
                max = sum;
                start = tempStart;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return IntStream.of(max, start, end).toArray();
    }

    public static void test(int[] arr, int[] expected) {
        int[] result = solution_2(arr, arr.length);
        if (Arrays.equals(result, expected)) {
            System.out.println("✅ Passed: " + Arrays.toString(result));
        } else {
            System.out.println("❌ Failed: expected " + Arrays.toString(expected) + ", got " + Arrays.toString(result));
        }
    }

    public static void main(String[] args) {
        test(new int[]{-2, 1, -3, 4, -1, 2, 1, -7, 4}, new int[]{6, 3, 6});
        test(new int[]{1}, new int[]{1, 0, 0});
    }
}
