package arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    private static int solution_1(int[] arr, int n) {
        if (n == 0) return 0;

        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE, count = 0, longest = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = arr[i];
            } else if (arr[i] != lastSmaller) {
                count = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    private static int solution_2(int[] arr, int n) {
        if (n == 0) return 0;
        Set<Integer> ms = new HashSet<>();
        for (int i : arr) ms.add(i);

        int max = 1;
        for (int i = 0; i < n; i++) {
            if (ms.contains(arr[i] - 1))
                continue;
            int count = 1, el = arr[i];
            while (ms.contains(el + 1)) {
                count++;
                el = el + 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private static void test(int[] input, int expected) {
        int result = LongestConsecutiveSequence.solution_2(input, input.length);
        if (expected == result) {
            System.out.println("✅ Passed: " + result);
        } else {
            System.out.println("❌ Failed: expected " + expected + ", got " + result);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Simple consecutive
        int[] input1 = {100, 4, 200, 1, 3, 2};
        int expected1 = 4; // Sequence: [1, 2, 3, 4]

        // Test Case 2: Duplicates present
        int[] input2 = {1, 2, 0, 1};
        int expected2 = 3; // Sequence: [0, 1, 2]

        // Test Case 3: Negative numbers
        int[] input3 = {9, -1, 0, 1, 2, 3};
        int expected3 = 5; // Sequence: [-1, 0, 1, 2, 3]

        // Test Case 4: Single element
        int[] input4 = {10};
        int expected4 = 1;

        // Test Case 5: All same elements
        int[] input5 = {7, 7, 7, 7};
        int expected5 = 1;

        // Test Case 6: Already sorted consecutive
        int[] input6 = {1, 2, 3, 4, 5, 6};
        int expected6 = 6;

        // Test Case 7: Reverse sorted input
        int[] input7 = {6, 5, 4, 3, 2, 1};
        int expected7 = 6;

        // Test Case 8: Gaps in sequence
        int[] input8 = {10, 5, 12, 3, 55, 30, 4, 11, 2};
        int expected8 = 4; // Sequence: [2, 3, 4, 5]

        // Test Case 9: Empty input
        int[] input9 = {};
        int expected9 = 0;

        // Test Case 10: Multiple sequences
        int[] input10 = {1, 9, 3, 10, 2, 20, 4, 100, 5};
        int expected10 = 5; // Sequence: [1, 2, 3, 4, 5]

        test(input1, expected1);
        test(input2, expected2);
        test(input3, expected3);
        test(input4, expected4);
        test(input5, expected5);
        test(input6, expected6);
        test(input7, expected7);
        test(input8, expected8);
        test(input9, expected9);
        test(input10, expected10);

    }
}
