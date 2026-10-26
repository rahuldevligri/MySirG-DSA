package a_Arrays.Array.Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Q5_RotateArray {
    public static void main(String[] args) {

        TwoPointerApproach(new int[] {1, 2, 3, 4, 5});
        System.out.println();

        BruteForceApproach(new  int[] {1, 2, 3, 4, 5});
        System.out.println();

        int[] arr = {1, 2, 3, 4, 5};
        RecursiveApproach(arr, 0, arr.length-1);
        for(int n : arr){
            System.out.print(n + " ");
        }
        System.out.println();

        StackApproach(new int[] {1, 2, 3, 4, 5});
        System.out.println();

        CollectionsReverseApproach(new Integer[]{1, 2, 3, 4, 5});

    }

    //Two Pointer Approach ⭐⭐⭐⭐⭐
    private static void TwoPointerApproach(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int temp =  arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        for(int n : arr){
            System.out.print(n + " ");
        }
    }/* time complexity: O(n)
    space comp: O(1)
     */

    //Using an Extra Array (Brute Force) ⭐⭐☆☆☆
    private static void BruteForceApproach(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = arr.length-1, j = 0; i >= 0; i--,j++) {
            rev[j] = arr[i];
        }
        for(int n : rev) {
            System.out.print(n + " ");
        }
    }/* time complexity: O(n)
    space comp: O(n)
     */

    //Using recursion ⭐⭐⭐☆☆
    private static void RecursiveApproach(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        RecursiveApproach(arr, l+1, r-1);
    }/* time complexity: O(n)
    space comp: O(n)
     */

    //Using stack approach ⭐⭐☆☆☆
    private static void StackApproach(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int n : arr){
            stack.push(n);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = stack.pop();
        }
        for (int n : arr){
            System.out.print(n + " ");
        }
    }/* time complexity: O(n)
    space comp: O(n)
     */

    //Using Collections.reverse() method ⭐☆☆☆☆
    private static void CollectionsReverseApproach(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        Collections.reverse(list);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }/* time complexity: O(n)
    space comp: O(1)
     */
}
