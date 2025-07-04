package arrays.medium;

public class SpiralMatrix {
    public static void solution_1(int[][] arr, int n, int m) {
        int top = 0, left = 0, right = m - 1, bottom = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " -> ");
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " -> ");
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " -> ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " -> ");
                }
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {20, 21, 22, 23, 24, 7},
                {19, 32, 33, 34, 25, 8},
                {18, 31, 36, 35, 26, 9},
                {17, 30, 29, 28, 27, 10},
                {16, 15, 14, 13, 12, 11}
        };
        SpiralMatrix.solution_1(mat, mat.length, mat[0].length);
    }
}
