package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSubarraySumEqualK {
    public static int solution_1(int[] arr, int n, int k) {
        if (n == 0) {
            if (k == 0) return 0;
            return -1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum != k)
                    continue;
                count++;
            }
        }
        return count;
    }

    public static int solution_2(int[] arr, int n, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int prefixSum = 0, count = 0;
        mp.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            int remaining = prefixSum - k;
            if (mp.containsKey(remaining)) {
                int remainingCount = mp.get(remaining);
                count += remainingCount;
            }
            int times = mp.getOrDefault(prefixSum, 0);
            mp.put(prefixSum, times + 1);
        }
        return count;
    }

    public static void test(int[] input, int k, int expected) {
        int result = CountSubarraySumEqualK.solution_2(input, input.length, k);
        if (result == expected) {
            System.out.println("✅ Passed: " + Arrays.toString(input) + " with k=" + k);
        } else {
            System.out.println("❌ Failed: " + Arrays.toString(input) + " with k=" + k + " => expected " + expected + ", got " + result);
        }
    }


    public static void main(String[] args) {
        // Test Case 1: Basic example
        int[] input1 = {1, 1, 1};
        int k1 = 2;
        int expected1 = 2;

        // Test Case 2: Include negative numbers
        int[] input2 = {1, 2, 3};
        int k2 = 3;
        int expected2 = 2; // [1,2], [3]

        // Test Case 3: Zero sum
        int[] input3 = {1, -1, 0};
        int k3 = 0;
        int expected3 = 3; // [1,-1], [0], [1,-1,0]

        // Test Case 4: All zeros, k = 0
        int[] input4 = {0, 0, 0};
        int k4 = 0;
        int expected4 = 6; // All subarrays

        // Test Case 5: Negative k
        int[] input5 = {-1, -1, 1};
        int k5 = 0;
        int expected5 = 1; // [-1,-1,1]

        // Test Case 6: Larger numbers
        int[] input6 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k6 = 7;
        int expected6 = 4;

        // Test Case 7: Single element equals k
        int[] input7 = {5};
        int k7 = 5;
        int expected7 = 1;

        // Test Case 8: Single element not equal to k
        int[] input8 = {5};
        int k8 = 10;
        int expected8 = 0;

        // Test Case 9: Empty array
        int[] input9 = {};
        int k9 = 0;
        int expected9 = 0;

        // Test Case 10: Multiple same values
        int[] input10 = {1, 2, 1, 2, 1};
        int k10 = 3;
        int expected10 = 4;

        int[] input11 = {3, -3, 1, 1, 1};
        int k11 = 3;
        int expected11 = 3;

        test(input1, k1, expected1);
        test(input2, k2, expected2);
        test(input3, k3, expected3);
        test(input4, k4, expected4);
        test(input5, k5, expected5);
        test(input6, k6, expected6);
        test(input7, k7, expected7);
        test(input8, k8, expected8);
        test(input9, k9, expected9);
        test(input10, k10, expected10);
        test(input11, k11, expected11);
    }
}
