package arrays.easy;

import java.util.*;

/**
 * Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
 * <p>
 * The union of two arrays can be defined as the common and distinct elements in the two arrays.NOTE: Elements in the union should be in ascending order.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * Input:
 * n = 5,m = 5.
 * arr1[] = {1,2,3,4,5}
 * arr2[] = {2,3,4,4,5}
 * Output:
 * {1,2,3,4,5}
 * <p>
 * Explanation:
 * Common Elements in arr1 and arr2  are:  2,3,4,5
 * Distnict Elements in arr1 are : 1
 * Distnict Elemennts in arr2 are : No distinct elements.
 * Union of arr1 and arr2 is {1,2,3,4,5}
 * <p>
 * Example 2:
 * Input:
 * n = 10,m = 7.
 * arr1[] = {1,2,3,4,5,6,7,8,9,10}
 * arr2[] = {2,3,4,4,5,11,12}
 * Output: {1,2,3,4,5,6,7,8,9,10,11,12}
 * Explanation:
 * Common Elements in arr1 and arr2  are:  2,3,4,5
 * Distnict Elements in arr1 are : 1,6,7,8,9,10
 * Distnict Elemennts in arr2 are : 11,12
 * Union of arr1 and arr2 is {1,2,3,4,5,6,7,8,9,10,11,12}
 */
public class UnionOfSortedArray {
    public static int[] solution_1(int[] arr1, int[] arr2) {
        Set<Integer> s = new HashSet<>();
        for (int i : arr1) s.add(i);
        for (int i : arr2) s.add(i);
        return new ArrayList<>(s).stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution_2(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        int lastElementInserted = Integer.MIN_VALUE;
        while (i < n1 && j < n2) {
            if (arr1[i] == arr2[j]) {
                lastElementInserted = arr1[i];
                result.add(arr1[i++]);
                j++;
            } else if (arr1[i] < arr2[j]) {
                if (lastElementInserted == Integer.MIN_VALUE || lastElementInserted != arr1[i]) {
                    result.add(arr1[i]);
                    lastElementInserted = arr1[i];
                }
                i++;
            } else {
                if (lastElementInserted == Integer.MIN_VALUE || lastElementInserted != arr2[j]) {
                    result.add(arr2[j]);
                    lastElementInserted = arr2[j];
                }
                j++;
            }
        }

        while (i < n1) {
            if (lastElementInserted == Integer.MIN_VALUE || lastElementInserted != arr1[i]) {
                result.add(arr1[i]);
                lastElementInserted = arr1[i];
            }
            i++;
        }

        while (j < n2) {
            if (lastElementInserted == Integer.MIN_VALUE || lastElementInserted != arr2[j]) {
                result.add(arr2[j]);
                lastElementInserted = arr2[j];
            }
            j++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5};
        int[] result1 = UnionOfSortedArray.solution_1(arr1, arr2);
        System.out.println("Task [1]: " + Arrays.toString(result1));

        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr4 = {2, 3, 4, 4, 5, 11, 12};
        int[] result2 = UnionOfSortedArray.solution_1(arr3, arr4);
        System.out.println("Task [2]: " + Arrays.toString(result2));
    }
}
