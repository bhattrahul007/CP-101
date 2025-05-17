package arrays.easy;

/**
 * Problem Statement: Given an array of size n, write a program to check if the given array is sorted in
 * (ascending / Increasing / Non-decreasing) order or not. If the array is sorted then return True, Else return False.
 * <p>
 * Note: Two consecutive equal values are considered to be sorted.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * Input: N = 5, array[] = {1,2,3,4,5}
 * Output: True.
 * Explanation: The given array is sorted i.e Every element in the array is smaller than or equals to its next values, So the answer is True.
 */
public class IsArraySorted {
    public static boolean solution_1(int[] arr, int n) {
        if (n < 2) return true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 6, 3};
        System.out.println("Test [1]: " + IsArraySorted.solution_1(arr1, arr1.length));
        System.out.println("Test [2]: " + IsArraySorted.solution_1(arr2, arr2.length));
    }
}
