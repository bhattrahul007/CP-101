package arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement: You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
 * Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
 * Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order
 * <p>
 * Example 2:
 * Input: 1,2,0,1,0,4,0
 * Output: 1,2,1,4,0,0,0
 * Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order
 */
public class MoveZeroToEnd {

    public static void solution_1(int[] arr, int n) {
        int zero_counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i : arr) {
            if (i == 0) zero_counter++;
            else result.add(i);
        }
        for (int i = 0; i < zero_counter; i++) result.add(0);
        for (int i = 0; i < n; i++) arr[i] = result.get(i);
    }


    public static void solution_2(int[] arr, int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 2, 3, 0, 4, 0, 1};
        int[] arr2 = {1, 2, 0, 1, 0, 4, 0};
        MoveZeroToEnd.solution_2(arr1, arr1.length);
        MoveZeroToEnd.solution_2(arr2, arr2.length);
        System.out.println("Test [1]: " + Arrays.toString(arr1));
        System.out.println("Test [2]: " + Arrays.toString(arr2));
    }
}
