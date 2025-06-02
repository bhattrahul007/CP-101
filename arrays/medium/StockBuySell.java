package arrays.medium;

class StockBuySell {


    public static int solution_1(int[] arr, int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int profit = arr[j] - arr[i];
                max = Math.max(max, profit);
            }
        }
        return max;
    }

    public static int solution_2(int[] arr, int n) {
        int max = 0, min = arr[0];
        for (int i = 1; i < n; i++) {
            int profit = arr[i] - min;
            max = Math.max(max, profit);
            min = Math.min(min, arr[i]);
        }
        return max;
    }

    public static void test(int[] input, int expected) {
        int result = StockBuySell.solution_2(input, input.length);
        if (result == expected) {
            System.out.println("✅ Passed: " + result);
        } else {
            System.out.println("❌ Failed: expected " + expected + ", got " + result);
        }
    }

    public static void main(String[] args) {
        test(new int[]{7, 1, 5, 3, 6, 4}, 5);
        test(new int[]{7, 6, 4, 3, 1}, 0);
    }
}