package arrays.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Statement: Given an integer array sorted in non-decreasing order, remove the duplicates in place such that
 * each unique element appears only once. The relative order of the elements should be kept the same.
 * <p>
 * If there are k elements after removing the duplicates, then the first k elements of the array should hold
 * the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Note: Return k after placing the final result in the first k slots of the array.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * <p>
 * Input: arr[1,1,2,2,2,3,3]
 * <p>
 * Output: arr[1,2,3,_,_,_,_]
 * <p>
 * Explanation: Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.
 * <p>
 * Example 2:
 * <p>
 * Input: arr[1,1,1,2,2,3,3,3,3,4,4]
 * <p>
 * Output: arr[1,2,3,4,_,_,_,_,_,_,_]
 * <p>
 * Explanation: Total number of unique elements are 4, i.e[1,2,3,4] and Therefore return 4 after assigning [1,2,3,4] in the beginning of the array.
 */
public class RemoveDuplicates {
    public static int solution_1(int[] arr, int n) {
        Set<Integer> unique_set = new HashSet<>();
        for (int i : arr) unique_set.add(i);

        int k = unique_set.size();
        int j = 0;
        for (int i : unique_set) {
            arr[j++] = i;
        }
        return k;
    }

    public static int solution_2(int[] arr, int n) {
        if (n < 2) return n;
        int i = 0;
        for (int j = i + 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void show(int[] arr, int n, int testNumber) {
        System.out.print("Test [" + testNumber + "]: ");
        for (int i = 0; i < n; i++) System.out.print(arr[i] + ", ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 2, 3, 3};
        int[] arr2 = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 4};
        int result1 = RemoveDuplicates.solution_2(arr1, arr1.length);
        System.out.println("Test [1]: " + result1);
        RemoveDuplicates.show(arr1, result1, 1);
        int result2 = RemoveDuplicates.solution_2(arr2, arr2.length);
        System.out.println("Test [2]: " + result2);
        RemoveDuplicates.show(arr2, result2, 2);
    }
}
