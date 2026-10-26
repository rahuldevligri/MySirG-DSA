package a_Arrays.Array.Practice;

public class Q1_ReverseArray {
    public static void main(String[] args) {
        twoPointerApproach(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println();

        bruteForceApproach(new int[]{1,2,3,4,5});
        System.out.println();

        int[] recursionArray = {1,2,3,4,5};
        recursionApproach(recursionArray, 0, recursionArray.length - 1);
        for(int i : recursionArray) {
            System.out.print(i + " ");
        }
    }

    //1 - Approach ⭐⭐☆☆☆
    private static void bruteForceApproach(int[] arr) {
        int[] reversedArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length-1-i];
        }
        for(int i : reversedArr) {
            System.out.print(i + " ");
        }
    }
    /*
    Time Complexity = O(n) -> because the work increases directly with the number of elements.
    Space Complexity = O(n) -> we created another array
    */

    //2 - Approach ⭐⭐⭐⭐⭐
    private static void twoPointerApproach(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        for(int i : array) {
            System.out.print(i + " ");
        }
    }
/* If array has 10 elements. Normally, visiting every element means 10 operations.
You stop in the middle. Only 5 swaps happen. That means n / 2 swaps
For 100 elements 50 swaps Mathematically, O(n/2) In Big-O notation,
we ignore constant numbers like 1/2  because they don't change how the algorithm grows.
So, O(n/2) --> O(n), So Whenever you see O(n/2), O(n/3), O(2n), O(5n)
they all become O(n) because Big-O ignores constant factors.

    Time Complexity: O(n)
    Space Complexity: O(1)

What extra variables did we create? left, right, temp Only 3 variables.
Whether the array has 5 elements or 5,00,000 elements we still use only 3 variables.
Memory does not increase with input size. So, Space Complexity = O(1)
*/

    //3 - Approach ⭐⭐⭐☆☆
    private static void recursionApproach(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        recursionApproach(arr, left+1, right-1);
    }
/* Every recursive call swaps one pair. There are approximately n / 2 recursive calls.
So, Time Complexity = O(n)

Each recursive call is stored in the call stack. For an array of size n,
there are about n/2 recursive calls. Extra memory grows with the input size.
So, Space Complexity = O(n)
*/
}
