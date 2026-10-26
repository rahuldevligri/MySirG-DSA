package a_Arrays.Array.Practice;

import java.util.Arrays;

public class Q2_LargestElement {
    public static void main(String[] args) {
        int[] arr = {10,25,8,40,15};
        int max = arr[0];
        int i = 1;

        System.out.println(iterativeApproach(arr, max, i));

        System.out.println(recursionApproach(arr, max, i));

        System.out.println(bruteForceApproach(arr));

    }
    //Linear Search ⭐⭐⭐⭐⭐
    private static int iterativeApproach(int[] arr, int max, int i) {
        while(i < arr.length){
            if(max < arr[i]){
                max = arr[i];
            }
            i++;
        }
        return max;
    }
    /*Time complexity: O(n) -> One complete traversal of the array = O(n).
    Space Complexity: O(1) -> variables are constant.
     */

    //2 - Recursion Approach ⭐⭐⭐☆☆
    private static int recursionApproach(int[] arr, int max, int i){
        if(i>=arr.length){
            return max;
        }
        return recursionApproach(arr, max<arr[i]? arr[i] : max, i+1);
    }/* Time complexity: O(n) -> There is one recursive call for each element.
    Space Complexity: O(n) -> Every recursive call is stored in the call stack.
     */

    //3 - using Arrays.sort() method ⭐⭐☆☆☆
    private static int bruteForceApproach(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
/* Time Complexity: O(n log n) -> Sorting is much more work than
just finding one number because it rearranges the entire array.

Space Complexity: O(log n) -> Arrays.sort() for primitive arrays is use O(log n)
*/
}
