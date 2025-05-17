package arrays.easy;

import java.util.Arrays;

/**
 * Problem Statement: Given an array of N integers, left rotate the array by one place.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * Input: N = 5, array[] = {1,2,3,4,5}
 * Output: 2,3,4,5,1
 * Explanation:
 * Since all the elements in array will be shifted
 * toward left by one so ‘2’ will now become the
 * first index and and ‘1’ which was present at
 * first index will be shifted at last.
 * <p>
 * <p>
 * Example 2:
 * Input: N = 1, array[] = {3}
 * Output: 3
 * Explanation: Here only element is present and so
 * the element at first index will be shifted to
 * last index which is also by the way the first index.
 */
public class LeftRotateByOne {
    public static void solution_1(int[] arr, int n) {
        if (n < 2) return;
        int temp = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3};
        LeftRotateByOne.solution_1(arr1, arr1.length);
        LeftRotateByOne.solution_1(arr2, arr2.length);
        System.out.println("Test [1]: " + Arrays.toString(arr1));
        System.out.println("Test [2]: " + Arrays.toString(arr2));
    }
}
