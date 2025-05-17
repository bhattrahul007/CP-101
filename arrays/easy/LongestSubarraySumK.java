package arrays.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k. (positives)
 * <p>
 * Examples
 * <p>
 * Example 1:
 * Input Format: N = 3, k = 5, array[] = {2,3,5}
 * Result: 2
 * Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.
 * <p>
 * Example 2:
 * Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
 * Result: 3
 */
public class LongestSubarraySumK {
    public static int solution_1(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    public static int solution_2(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int prefix = 0;
        int max = 0;
        mp.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefix += arr[i];
            if (prefix == k) max = Math.max(max, i + 1);
            int remaining = prefix - k;
            if (mp.containsKey(remaining)) {
                int start = mp.get(remaining);
                max = Math.max(max, i - start);
            }
            if (!mp.containsKey(prefix)) mp.put(prefix, i);
        }
        return max;
    }

    public static int solution_3(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int prefix = 0, max = 0;
        for (int j = 0; j < n; j++) {
            prefix += arr[j];
            while (i <= j && prefix > k) {
                prefix -= arr[i];
                i++;
            }
            if (prefix == k) {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 5};
        int k1 = 3;
        int[] arr2 = {2, 3, 5, 1, 9};
        int k2 = 5;
        int[] arr3 = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int k3 = 3;
        System.out.println("Task [1] " + LongestSubarraySumK.solution_3(arr1, k1));
        System.out.println("Task [2] " + LongestSubarraySumK.solution_3(arr2, k2));
        System.out.println("Task [3] " + LongestSubarraySumK.solution_3(arr3, k3));
    }
}
