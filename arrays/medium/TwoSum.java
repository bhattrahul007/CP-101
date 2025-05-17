package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement: Given an array of integers arr[] and an integer target.
 * <p>
 * 1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
 * <p>
 * 2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.
 * <p>
 * Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
 * Result: YES (for 1st variant)
 * [1, 3] (for 2nd variant)
 * Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.
 * <p>
 * Example 2:
 * Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
 * Result: NO (for 1st variant)
 * [-1, -1] (for 2nd variant)
 * Explanation: There exist no such two numbers whose sum is equal to the target.
 */
public class TwoSum {
    public static boolean solution_1(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == k) return true;
            }
        }
        return false;
    }

    public static boolean solution_2(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int remaining = k - arr[i];
            if (mp.containsKey(remaining)) {
                return true;
            }
            mp.put(arr[i], i);
        }
        return false;
    }

    public static boolean solution_3(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] > k) right--;
            else if (arr[left] + arr[right] < k) left++;
            else if (arr[left] + arr[right] == k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 5, 8, 11};
        int k1 = 14;
        int[] arr2 = {2, 6, 5, 8, 11};
        int k2 = 15;
        System.out.println("Task [1]: " + TwoSum.solution_3(arr1, k1));
        System.out.println("Task [2]: " + TwoSum.solution_3(arr2, k2));
    }
}
