package arrays.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * Input Format: arr[] = {2,2,1}
 * Result: 1
 * Explanation: In this array, only the element 1 appear once and so it is the answer.
 * <p>
 * Example 2:
 * Input Format: arr[] = {4,1,2,1,2}
 * Result: 4
 * Explanation: In this array, only element 4 appear once and the other elements appear twice. So, 4 is the answer.
 */
public class NumberAppearingOnce {
    public static int solution_1(int[] arr, int n) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int count = entry.getValue();
            if (count == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int solution_2(int[] arr, int n) {
        int xor = 0;
        for (int i : arr) xor = xor ^ i;
        return xor;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 1};
        int[] arr2 = {4, 1, 2, 1, 2};
        System.out.println("Task [1]: " + NumberAppearingOnce.solution_2(arr1, arr1.length));
        System.out.println("Task [2]: " + NumberAppearingOnce.solution_2(arr2, arr2.length));
    }
}
