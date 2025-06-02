package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersInArray {
    public static int[] solution_1(int[] arr, int n) {
        List<Integer> leaders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int leader = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[i]) {
                    leader = 0;
                    break;
                }
            }
            if (leader == 1) {
                leaders.add(arr[i]);
            }
        }
        return leaders.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution_2(int[] arr, int n) {
        if (n == 0) return new int[]{};
        List<Integer> leaders = new ArrayList<>();
        leaders.add(arr[n - 1]);
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                leaders.add(arr[i]);
                max = arr[i];
            }
        }
        return leaders.reversed().stream().mapToInt(Integer::intValue).toArray();
    }

    public static void test(int[] input, int[] expected) {
        int[] result = LeadersInArray.solution_2(input, input.length);
        if (Arrays.equals(result, expected)) {
            System.out.println("✅ Passed: " + Arrays.toString(result));
        } else {
            System.out.println("❌ Failed: expected " + Arrays.toString(expected) + ", got " + Arrays.toString(result));
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Basic case
        int[] input1 = {16, 17, 4, 3, 5, 2};
        int[] expected1 = {17, 5, 2};

        // Test Case 2: All decreasing elements (all are leaders)
        int[] input2 = {9, 7, 5, 3, 1};
        int[] expected2 = {9, 7, 5, 3, 1};

        // Test Case 3: All increasing elements (only last is leader)
        int[] input3 = {1, 2, 3, 4, 5};
        int[] expected3 = {5};

        // Test Case 4: Duplicates and leaders
        int[] input4 = {7, 10, 4, 10, 6, 5, 2};
        int[] expected4 = {10, 6, 5, 2};

        // Test Case 5: All same elements
        int[] input5 = {5, 5, 5, 5};
        int[] expected5 = {5};

        // Test Case 6: Single element
        int[] input6 = {99};
        int[] expected6 = {99};

        // Test Case 7: Two elements
        int[] input7 = {2, 1};
        int[] expected7 = {2, 1};

        // Test Case 8: Zero and negative numbers
        int[] input8 = {0, -1, -3, 2, 1};
        int[] expected8 = {2, 1};

        // Test Case 9: Negative-only elements
        int[] input9 = {-5, -10, -3, -1};
        int[] expected9 = {-1};

        // Test Case 10: Empty array
        int[] input10 = {};
        int[] expected10 = {};

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