package a_Arrays.Array.Practice;

import java.util.Arrays;

public class Q3_SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {40, 30, 20, 10};//{10,25,8,40,15};
        OneTraversal(arr);
        BruteForce(arr);

    }

    //One Traversal Approach ⭐⭐⭐⭐⭐
    private static void OneTraversal(int[] arr) {
        int secondLargest = Integer.MIN_VALUE;
        int largest = arr[0];
        int i = 1;
        while (i < arr.length) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
            i++;
        }
        System.out.println(secondLargest + " " + largest);
    }/* Time Complexity: O(n)
    Space Complexity: O(1)
     */

    //Two Traversals Approach
    private static void TwoTraversal(int[] arr) {
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        System.out.println(secondLargest);
    }
    /* Time Complexity: O(2n) -> Big-O ignores the constant 2, so O(n)
    Space Complexity: O(1)
    */

    //Sorting Approach ⭐⭐☆☆☆
    private static void BruteForce(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 2]);
    }
    /* Time Complexity: O(n log n)
    Space Complexity: O(log n)
     */
}



























