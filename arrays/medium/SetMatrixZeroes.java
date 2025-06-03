package arrays.medium;

import java.util.Arrays;

public class SetMatrixZeroes {
    private static void solution_1(int[][] arr, int n, int m) {
        int[] rows = new int[n];
        int[] columns = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0)
                    continue;
                rows[i] = 1;
                columns[j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean isMarked = rows[i] == 1 || columns[j] == 1;
                if (!isMarked) continue;
                arr[i][j] = 0;
            }
        }
    }

    public static void solution_2(int[][] arr, int n, int m) {
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if (j != 0)
                        arr[0][j] = 0;
                    else col0 = 0;
                }
            }
        }
        System.out.println("This is my col 0 value " + col0);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] != 0 && (arr[i][0] == 0 || arr[0][j] == 0)) {
                    arr[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (arr[0][0] == 0)
                arr[0][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (col0 == 0)
                arr[i][0] = 0;
        }

    }

    public static void test(int[][] input, int[][] expected) {
        SetMatrixZeroes.solution_2(input, input.length, input[0].length);
        if (Arrays.deepEquals(input, expected)) {
            System.out.println("✅ Passed: " + Arrays.deepToString(input));
        } else {
            System.out.println("❌ Failed: expected " + Arrays.deepToString(expected) + ", got " + Arrays.deepToString(input));
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Basic 3x3 matrix
        int[][] input1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] expected1 = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        // Test Case 2: Multiple zeros
        int[][] input2 = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        int[][] expected2 = {
                {0, 0, 0},
                {0, 5, 0},
                {0, 0, 0}
        };

        // Test Case 3: No zero
        int[][] input3 = {
                {1, 2},
                {3, 4}
        };
        int[][] expected3 = {
                {1, 2},
                {3, 4}
        };

        // Test Case 4: All zero
        int[][] input4 = {
                {0, 0},
                {0, 0}
        };
        int[][] expected4 = {
                {0, 0},
                {0, 0}
        };

        // Test Case 5: 1x1 with 0
        int[][] input5 = {
                {0}
        };
        int[][] expected5 = {
                {0}
        };

        // Test Case 6: 1x1 without 0
        int[][] input6 = {
                {9}
        };
        int[][] expected6 = {
                {9}
        };

        // Test Case 7: Row only
        int[][] input7 = {
                {1, 0, 3}
        };
        int[][] expected7 = {
                {0, 0, 0}
        };

        // Test Case 8: Column only
        int[][] input8 = {
                {5},
                {0},
                {7}
        };
        int[][] expected8 = {
                {0},
                {0},
                {0}
        };

        test(input1, expected1);
        test(input2, expected2);
        test(input3, expected3);
        test(input4, expected4);
        test(input5, expected5);
        test(input6, expected6);
        test(input7, expected7);
        test(input8, expected8);
    }
}