package arrays.easy;

/**
 * Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * Input Format: N = 5, array[] = {1,2,4,5}
 * Result: 3
 * Explanation: In the given array, number 3 is missing. So, 3 is the answer.
 * <p>
 * Example 2:
 * Input Format: N = 3, array[] = {1,3}
 * Result: 2
 * Explanation: In the given array, number 2 is missing. So, 2 is the answer.
 */
public class MissingNumber {
    public static int solution_1(int[] arr, int n) {
        int expected = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i : arr) sum += i;
        return expected - sum;
    }

    public static int solution_2(int[] arr, int n) {
        int xor = 0;
        for (int i : arr) xor = xor ^ i;
        for (int i = 1; i <= n; i++) xor = xor ^ i;
        return xor;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5};
        int n1 = 5;
        int[] arr2 = {1, 3};
        int n2 = 3;

        System.out.println("Task [1]: " + MissingNumber.solution_2(arr1, n1));
        System.out.println("Task [2]: " + MissingNumber.solution_2(arr2, n2));
    }
}
