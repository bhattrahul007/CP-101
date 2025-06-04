package arrays.hard;

public class PascalTriangle {

    public static int findBinomialCofficient(int n, int k) {
        if (n == k || (n == 0 || k == 0)) return 1;
        int upper = 1;
        int lower = 1;
        for (int i = 1; i <= k; i++) {
            upper *= (n - i + 1);
            lower *= i;
        }
        return upper / lower;
    }

    public static void printPascalRow(int row) {
        int ans = 1;
        for (int i = 0; i < row; i++) {
            if (i == 0 || i == row - 1) {
                System.out.print(1 + " ");
            } else {
                ans = (ans * (row - i)) / i;
                System.out.print(ans + " ");
            }
        }
    }


    public static void main(String[] args) {
        int n = 6;
        for (int i = 1; i <= n; i++) {
            printPascalRow(i);
            System.out.println();
        }
    }
}
