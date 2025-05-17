package arrays.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Problem Statement: Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either
 * of them doesn’t exist.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * Input: [1,2,4,7,7,5]
 * Output: Second Smallest : 2
 * Second Largest : 5
 * Explanation: The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2
 * <p>
 * Example 2:
 * Input: [1]
 * Output: Second Smallest : -1
 * Second Largest : -1
 * Explanation: Since there is only one element in the array, it is the largest and smallest element present in the array.
 * There is no second largest or second smallest element present.
 */
public class SecondLargestAndSmallest {
    public static int[] solution_1(int[] arr, int n) {
//        this condition here is to avoid going for sorting if array is of size equal or less than 2
        if (n < 2 || (n == 2 && arr[0] == arr[1])) return IntStream.of(-1, -1).toArray();
        if (n == 2) {
            int max = Math.max(arr[0], arr[1]);
            int min = Math.min(arr[0], arr[1]);
            return IntStream.of(max, min).toArray();
        }
        Arrays.sort(arr);
        int smallest = arr[0];
        int largest = arr[n - 1];
        int secondSmallest = -1;
        int secondLargest = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] != smallest && secondSmallest == -1)
                secondSmallest = arr[i];
            if (arr[i] != largest) secondLargest = arr[i];
        }
        return IntStream.of(secondSmallest, secondLargest).toArray();
    }

    public static int[] solution_2(int[] arr, int n) {
        if (n < 2 || (n == 2 && arr[0] == arr[1])) return IntStream.of(-1, -1).toArray();
        if (n == 2) {
            int max = Math.max(arr[0], arr[1]);
            int min = Math.min(arr[0], arr[1]);
            return new int[]{max, min};
        }
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i < smallest) {
                secondSmallest = smallest;
                smallest = i;
            } else if (i < secondSmallest && i > smallest)
                secondSmallest = i;
            if (i > largest) {
                secondLargest = largest;
                largest = i;
            } else if (i > secondLargest && i < largest)
                secondLargest = i;
        }

        if (secondSmallest == Integer.MAX_VALUE || secondLargest == Integer.MIN_VALUE) {
            secondSmallest = -1;
            secondLargest = -1;
        }
        return new int[]{secondSmallest, secondLargest};
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 7, 7, 5};
        int[] arr2 = {1};
        int[] arr3 = {34, 34, 34, 34};
//        System.out.println("Test [1]: " + Arrays.toString(SecondLargestAndSmallest.solution_1(arr1, arr1.length)));
//        System.out.println("Test [2]: " + Arrays.toString(SecondLargestAndSmallest.solution_1(arr2, arr2.length)));
//        System.out.println("Test [3]: " + Arrays.toString(SecondLargestAndSmallest.solution_1(arr3, arr3.length)));
        System.out.println("Test [1]: " + Arrays.toString(SecondLargestAndSmallest.solution_2(arr1, arr1.length)));
        System.out.println("Test [2]: " + Arrays.toString(SecondLargestAndSmallest.solution_2(arr2, arr2.length)));
        System.out.println("Test [3]: " + Arrays.toString(SecondLargestAndSmallest.solution_2(arr3, arr3.length)));
    }
}
