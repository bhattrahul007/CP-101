package arrays.medium;

import java.util.Arrays;

/**
 * Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
 * <p>
 * Examples
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * Input: nums = [0]
 * Output: [0]
 */
public class SortZeroOneAndTwo {
    public static void solution_1(int[] arr, int n) {
        int zero_count = 0, one_count = 0, two_count = 0;
        for (int i : arr) {
            if (i == 0) zero_count++;
            else if (i == 1) one_count++;
            else two_count++;
        }
        for (int i = 0; i < n; i++) {
            if (zero_count > 0) {
                arr[i] = 0;
                zero_count--;
            } else if (one_count > 0) {
                arr[i] = 1;
                one_count--;
            } else {
                arr[i] = 2;
                two_count--;
            }
        }
    }

    public static void solution_2(int[] arr, int n) {
        int i = 0, j = 0;
        int k = n - 1;
        while (j <= k) {
            if (arr[j] == 0) {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j++] = temp;
            } else if (arr[j] == 2) {
                int temp = arr[k];
                arr[k--] = arr[j];
                arr[j] = temp;
            } else j++;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 0, 1, 2, 0, 1, 1, 0};
        int[] arr2 = {2, 0, 2, 1, 1, 0};
        SortZeroOneAndTwo.solution_2(arr1, arr1.length);
        SortZeroOneAndTwo.solution_2(arr2, arr2.length);
        System.out.println("Task [1]: " + Arrays.toString(arr1));
        System.out.println("Task [3]: " + Arrays.toString(arr2));
    }
}
