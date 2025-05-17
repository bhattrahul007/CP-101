package arrays.medium;

class Node {
    public static int majorityCount = 0;
    public int count;
    public int val;
    public Node left, right;

    public Node(int val, int count) {
        this.val = val;
        this.count = count;
        this.left = this.right = null;
    }

    public void increment() {
        this.count++;
    }
}


/**
 * Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * Input Format: N = 3, nums[] = {3,2,3}
 * Result: 3
 * Explanation: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution.
 * <p>
 * Example 2:
 * Input Format:  N = 7, nums[] = {2,2,1,1,1,2,2}
 * <p>
 * Result: 2
 * <p>
 * Explanation: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.
 * <p>
 * Example 3:
 * Input Format:  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}
 * <p>
 * Result: 4
 */
public class MajorityElement {
    public static Node insert(int i, Node root) {
        if (root == null) {
            Node.majorityCount = Math.max(Node.majorityCount, 1);
            return new Node(i, 1);
        }
        if (root.val == i) {
            root.increment();
            Node.majorityCount = Math.max(Node.majorityCount, root.count);
            return root;
        } else if (i < root.val) {
            root.left = insert(i, root.left);
            return root;
        } else {
            root.right = insert(i, root.right);
            return root;
        }
    }

    public static int getMajority(Node root) {
        if (root == null) return -1;
        if (root.count == Node.majorityCount) {
            return root.val;
        }
        int leftValue = getMajority(root.left);
        if (leftValue != -1) return leftValue;
        return getMajority(root.right);
    }


    public static int solution_1(int[] arr, int n) {
        int threshold = n / 2;
        int target = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == arr[i]) count++;
            }
            if (count >= threshold) {
                target = arr[i];
                break;
            }
        }
        return target;
    }

    public static int solution_2(int[] arr, int n) {
        int threshold = n / 2;
        Node.majorityCount = 0;
        Node root = null;
        for (int i : arr) {
            root = insert(i, root);
        }
        if (Node.majorityCount > threshold) {
            return getMajority(root);
        }
        return -1;
    }

    public static int solution_3(int[] arr, int n) {
        int count = 0, lastEl = -1, threshold = n / 2;
        for (int i : arr) {
            if (count == 0) {
                count = 1;
                lastEl = i;
            } else {
                if (i != lastEl) count--;
                else count++;
            }
        }
        int confirmCount = 0;
        for (int i : arr) {
            if (i == lastEl) confirmCount++;
        }
        if (confirmCount > threshold) return lastEl;
        return -1;
    }

    public static void test(int[] input, int expected) {
        int result = solution_2(input, input.length);
        if (result == expected) {
            System.out.println("✅ Passed: " + result);
        } else {
            System.out.println("❌ Failed: expected " + expected + ", got " + result);
        }
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 2, 2, 3, 2, 2}, 2);       // TC1: Majority element 2
        test(new int[]{3, 3, 3, 1, 2, 3, 3}, 3);       // TC2: Majority element 3
        test(new int[]{1, 1, 2, 1, 3, 1, 4}, 1);       // TC3: Majority element 1
        test(new int[]{9, 9, 9, 9, 9, 9}, 9);          // TC4: All elements are same, majority 9
        test(new int[]{1, 2, 3, 4}, -1);                // TC5: No majority element, expected -1
        test(new int[]{1, 1, 2, 2, 3, 3}, -1);          // TC6: No majority element, expected -1
        test(new int[]{2, 3, 4, 2, 3, 4}, -1);          // TC7: No majority element, expected -1
        test(new int[]{1, 2, 3, 2, 1, 3}, -1);          // TC8: No majority element, expected -1

    }
}
