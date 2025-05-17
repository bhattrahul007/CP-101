package arrays.easy;

/**
 * Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * <p>
 * Input: prices = {1, 1, 0, 1, 1, 1}
 * <p>
 * Output: 3
 * <p>
 * Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.
 * <p>
 * Input: prices = {1, 0, 1, 1, 0, 1}
 * <p>
 * Output: 2
 * <p>
 * Explanation: There are two consecutive 1's in the array.
 */
public class MaxConsecutiveOne {
    public static int solution_1(int[] arr, int n) {
        int max = 0, count = 0;
        for (int i : arr) {
            if (i == 0) {
                max = Math.max(count, max);
                count = 0;
            } else count += 1;
        }
        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 0, 1, 1, 1};
        int[] arr2 = {0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1};
        System.out.println("Task [1]: " + MaxConsecutiveOne.solution_1(arr1, arr1.length));
        System.out.println("Task [2]: " + MaxConsecutiveOne.solution_1(arr2, arr2.length));
    }
}
