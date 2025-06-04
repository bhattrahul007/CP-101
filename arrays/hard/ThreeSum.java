package arrays.hard;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public static List<List<Integer>> solution_1(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> ss = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> tmp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(tmp);
                        ss.add(tmp);
                    }
                }
            }
        }
        return ss.stream().toList();
    }

    public static List<List<Integer>> solution_2(int[] arr) {
        Set<List<Integer>> ss = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            HashMap<Integer, Integer> mp = new HashMap<>();
            for (int j = i + 1; j < arr.length; j++) {
                int lookupValue = -1 * (arr[i] + arr[j]);
                if (mp.containsKey(lookupValue)) {
                    List<Integer> tmp = Arrays.asList(arr[i], arr[j], lookupValue);
                    Collections.sort(tmp);
                    ss.add(tmp);
                }
                mp.put(arr[j], j);
            }
        }
        return ss.stream().toList();
    }

    public static List<List<Integer>> solution_3(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    List<Integer> tmp = Arrays.asList(arr[i], arr[j], arr[k]);
                    result.add(tmp);
                    j++;
                    k--;
                    while (arr[j] == arr[j - 1] && j < k) j++;
                    while (arr[k] == arr[k + 1] && k > j) k--;
                } else if (sum < 0) j++;
                else k--;
            }
        }
        return result;
    }

    public static void test(int[] input, List<List<Integer>> expected) {
        List<List<Integer>> result = solution_3(input);

        // Sort each triplet in both lists
        result = result.stream()
                .map(ArrayList::new)
                .peek(Collections::sort)
                .collect(Collectors.toList());

        expected = expected.stream()
                .map(ArrayList::new)
                .peek(Collections::sort)
                .collect(Collectors.toList());

        // Sort outer list
        Comparator<List<Integer>> tripletComparator = Comparator
                .comparing((List<Integer> l) -> l.get(0))
                .thenComparing(l -> l.get(1))
                .thenComparing(l -> l.get(2));

        result.sort(tripletComparator);
        expected.sort(tripletComparator);

        if (result.equals(expected)) {
            System.out.println("✅ Passed: " + Arrays.toString(input));
        } else {
            System.out.println("❌ Failed: " + Arrays.toString(input));
            System.out.println("   Expected: " + expected);
            System.out.println("   Got     : " + result);
        }
    }

    public static void main(String[] args) {
        test(new int[]{-1, 0, 1, 2, -1, -4}, Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        ));

        test(new int[]{0, 1, 1}, Collections.emptyList());

        test(new int[]{0, 0, 0}, Arrays.asList(
                Arrays.asList(0, 0, 0)
        ));

        test(new int[]{-2, 0, 1, 1, 2}, Arrays.asList(
                Arrays.asList(-2, 0, 2),
                Arrays.asList(-2, 1, 1)
        ));

        test(new int[]{}, Collections.emptyList());

        test(new int[]{0}, Collections.emptyList());

        test(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}, Arrays.asList(
                Arrays.asList(-4, -2, 6),
                Arrays.asList(-4, 0, 4),
                Arrays.asList(-4, 1, 3),
                Arrays.asList(-4, 2, 2),
                Arrays.asList(-2, -2, 4),
                Arrays.asList(-2, 0, 2)
        ));
    }
}
