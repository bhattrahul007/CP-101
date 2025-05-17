package arrays.easy;

import java.util.Arrays;

/**
 * Problem Statement: Given an array, we have to find the largest element in the array.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * Input: arr[] = {2,5,1,3,0};
 * Output: 5
 * Explanation: 5 is the largest element in the array.
 * <p>
 * Example2:
 * Input: arr[] = {8,10,5,7,9};
 * Output: 10
 * Explanation: 10 is the largest element in the array.
 */
public class LargestElement {
    public static int greater(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public static int solution_1(int[] arr, int n) {
        if (n == 0) return -1;
        if (n == 1) return arr[0];
        if (n == 2) return LargestElement.greater(arr[0], arr[1]);
        Arrays.sort(arr);
        return arr[n - 1];
    }

    public static int solution_2(int[] arr, int n) {
        if (n == 0) return -1;
        if (n == 1) return arr[0];
        if (n == 2) return LargestElement.greater(arr[0], arr[1]);

        int max = -1;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 5, 1, 3, 0};
//        System.out.println("Test [1]: " + LargestElement.solution_1(arr1, arr1.length));
        System.out.println("Test [1]: " + LargestElement.solution_2(arr1, arr1.length));
        int[] arr2 = {8, 10, 5, 7, 9};
//        System.out.println("Test [2]: " + LargestElement.solution_1(arr2, arr2.length));
        System.out.println("Test [2]: " + LargestElement.solution_2(arr2, arr2.length));
    }
}
