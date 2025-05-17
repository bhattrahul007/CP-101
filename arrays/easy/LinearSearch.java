package arrays.easy;

import java.util.Arrays;

/**
 * Problem Statement: Given an array, and an element num the task is to find if num is present in the given array or not.
 * If present print the index of the element or print -1.
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: arr[]= 1 2 3 4 5, num = 3
 * Output: 2
 * Explanation: 3 is present in the 2nd index
 * <p>
 * Example 2:
 * Input: arr[]= 5 4 3 2 1, num = 5
 * Output: 0
 * Explanation: 5 is present in the 0th index
 */
public class LinearSearch {
    public static int solution_1(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) return i;
        }
        return -1;
    }

    //    only on practice for binary search
    public static int solution_2(int[] arr, int n) {
        if (!IsArraySorted.solution_1(arr, arr.length))
            Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == n) return mid;
            if (arr[mid] > n) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};

        System.out.println("Task [1]: " + LinearSearch.solution_2(arr1, 3));
        System.out.println("Task [2]: " + LinearSearch.solution_2(arr2, 5));
    }
}
