package a_Arrays.Array.Practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q4_FindMissingNum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int N = 5;
        LinearSearchApproach(arr, N);
        SortingApproach(arr, N);
        SumFormulaApproach(arr, N);
        XORApproach(arr, N);
        HashSetApproach(arr, N);
    }

    //Linear Search Approach ⭐⭐☆☆☆
    private static void LinearSearchApproach(int[] arr, int n) {
        for(int i=1; i<=n; i++){
            boolean flg = false;
            for(int j=0; j<arr.length; j++){
                if(arr[j]==i){
                    flg = true;
                    break;
                }
            }
            if(!flg){
                System.out.println(i);
            }
        }
    }
    /* time complexity: O(n²)
    space comp: O(1)
     */

    //SortingApproach ☆☆☆☆☆
    private static void SortingApproach(int[] arr, int n){
        Arrays.sort(arr);
        int expected = 1;
        for(int num : arr){
            if(num != expected){
                System.out.println(expected);
                return;
            }
            expected++;
        }
        System.out.println("Missing Number = " + n);
    }/* time complexity: O(n log n)
    space comp: O(log n)
     */

    //Sum Formula ⭐⭐⭐⭐☆
    private static void SumFormulaApproach(int[] arr, int n) {
        int expectedSum = n * (n+1) / 2;
        int actualSum = 0;
        for(int num : arr){
            actualSum += num;
        }
        System.out.println("Missing Number: = " + (expectedSum - actualSum));
    }/* time complexity: O(n)
    space comp: O(1)
     */

    //XOR approach ⭐⭐⭐⭐⭐
    private static void XORApproach(int[] arr, int n) {
        int xor1=0;
        int xor2=0;
        for(int i=1; i<=n; i++){
            xor1 ^= i;
        }
        for (int num : arr) {
            xor2 ^= num;
        }
        System.out.println(xor1^xor2);
    }/* time complexity: O(n)
    space comp: O(1)
     */

    //HashSet Approach ⭐⭐⭐☆☆
    private static void HashSetApproach(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        for(int i=1; i<=n; i++){
            if(!set.contains(i)){
                System.out.println(i);
                break;
            }
        }
    }/* time complexity: O(n)
    space comp: O(n)
     */
}