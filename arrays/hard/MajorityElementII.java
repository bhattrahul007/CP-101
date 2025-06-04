package arrays.hard;

import java.util.*;

public class MajorityElementII {
    public static List<Integer> solution_1(int[] arr, int n) {
        int minRequired = (n / 3) + 1;
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count >= minRequired && !mp.containsKey(arr[i])) {
                result.add(arr[i]);
                mp.put(arr[i], 1);
            }
        }
        return result;
    }

    public static List<Integer> solution_2(int[] arr, int n) {
        int minRequired = (n / 3) + 1;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(arr[i])) {
                mp.compute(arr[i], (k, times) -> {
                    if (times != null)
                        return times + 1;
                    return 0;
                });
                continue;
            }
            mp.put(arr[i], 1);
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value >= minRequired) result.add(key);
        }

        return result;
    }

    public static boolean checkIfMajority(int[] arr, int k) {
        int count = 0, minRequired = (arr.length) / 3;
        for (int j : arr) {
            if (j != k) continue;
            count++;
            if (count > minRequired) return true;
        }
        return false;
    }

    public static List<Integer> solution_3(int[] arr, int n) {
        int count1 = 0, el1 = -1;
        int count2 = 0, el2 = -1;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && arr[i] != el2) {
                count1 = 1;
                el1 = arr[i];
            } else if (count2 == 0 && arr[i] != el1) {
                count2 = 1;
                el2 = arr[i];
            } else if (el1 == arr[i]) count1++;
            else if (el2 == arr[i]) count2++;
            else {
                count1--;
                count2--;

            }
        }
        List<Integer> result = new ArrayList<>();
        if (checkIfMajority(arr, el1)) result.add(el1);
        if (checkIfMajority(arr, el2)) result.add(el2);
        return result;
    }

    public static void test(int[] input, List<Integer> expected) {
        List<Integer> result = MajorityElementII.solution_3(input, input.length);
        Collections.sort(result);
        Collections.sort(expected);
        if (result.equals(expected)) {
            System.out.println("✅ Passed: " + Arrays.toString(input));
        } else {
            System.out.println("❌ Failed: " + Arrays.toString(input) + " => expected " + expected + ", got " + result);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Single majority
        test(new int[]{3, 2, 3}, Arrays.asList(3));

        // Test Case 2: Two majorities
        test(new int[]{1, 1, 1, 3, 3, 2, 2, 2}, Arrays.asList(1, 2));

        // Test Case 3: No majority
        test(new int[]{1, 2, 3, 4}, Arrays.asList());

        // Test Case 4: All same elements
        test(new int[]{2, 2, 2, 2}, Arrays.asList(2));

        // Test Case 5: Exactly n/3 threshold
        test(new int[]{1, 2, 2, 3, 3, 3}, Arrays.asList(3));

        // Test Case 6: Large case with two majorities
        test(new int[]{4, 4, 4, 5, 5, 5, 6}, Arrays.asList(4, 5));

        // Test Case 7: Empty array
        test(new int[]{}, Arrays.asList());

        // Test Case 8: One element
        test(new int[]{7}, Arrays.asList(7));

        // Test Case 9: Two elements, same
        test(new int[]{9, 9}, Arrays.asList(9));

        // Test Case 10: Two elements, different
        test(new int[]{9, 8}, Arrays.asList(8, 9));
    }
}
