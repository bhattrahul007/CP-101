package arrays.medium;

import java.util.Arrays;

public class RotateBy90 {
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[end];
            arr[end--] = arr[start];
            arr[start++] = temp;
        }
    }

    public static int[][] solution_1(int[][] arr, int n, int m) {
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - 1 - i] = arr[i][j];
            }
        }
        return result;
    }

    public static int[][] solution_2(int[][] arr, int n, int m) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(arr[i], 0, arr[i].length - 1);
        }
        return arr;
    }

    public static void test(int[][] input, int[][] expected) {
        int[][] result = RotateBy90.solution_2(input, input.length, input[0].length);  // rotates in-place
        if (Arrays.deepEquals(result, expected)) {
            System.out.println("✅ Passed: " + Arrays.deepToString(input));
        } else {
            System.out.println("❌ Failed: expected " + Arrays.deepToString(expected) + ", got " + Arrays.deepToString(input));
        }
    }

    public static void main(String[] args) {
        // Test Case 1: 1x1 matrix
        int[][] input1 = {
                {1}
        };
        int[][] expected1 = {
                {1}
        };

        // Test Case 2: 2x2 matrix
        int[][] input2 = {
                {1, 2},
                {3, 4}
        };
        int[][] expected2 = {
                {3, 1},
                {4, 2}
        };

        // Test Case 3: 3x3 matrix
        int[][] input3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected3 = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        // Test Case 4: 4x4 matrix
        int[][] input4 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] expected4 = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };

        // Test Case 5: All same elements
        int[][] input5 = {
                {1, 1},
                {1, 1}
        };
        int[][] expected5 = {
                {1, 1},
                {1, 1}
        };

        test(input1, expected1);
        test(input2, expected2);
        test(input3, expected3);
        test(input4, expected4);
        test(input5, expected5);
    }
}
