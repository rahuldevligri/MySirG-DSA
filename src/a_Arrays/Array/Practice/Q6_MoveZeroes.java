package a_Arrays.Array.Practice;

public class Q6_MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,3,12};

        BubbleSwapApproach(arr);
        System.out.println();

        BruteForceApproach(arr);
        System.out.println();

        TwoTraversal(arr);
        System.out.println();

        TwoPointer(arr);

    }

    //Bubble Swap ⭐☆☆☆☆
    private static void BubbleSwapApproach(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j <= arr.length - 1 - i; j++){
                if(arr[j] == 0){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int num : arr){
            System.out.print(num + " ");
        }
    }/* Time Complexity: O(n²)
    Space Complexity: O(1)
    */

    //Extra Array (Brute Force) ⭐⭐☆☆☆
    private static void BruteForceApproach(int[] arr){
        int[] nonZeroArr = new int[arr.length];
        int index = 0;
        for (int num : arr) {
            if (num != 0) {
                nonZeroArr[index++] = num;
            }
        }

        for(int num : nonZeroArr){
            System.out.print(num + " ");
        }
    } /* Time Complexity: O(n)
    Space Complexity: O(n)
    */

    //Two Traversal ⭐⭐⭐⭐☆
    private static void TwoTraversal(int[] arr){
        int index = 0;
         for(int i = 0; i < arr.length; i++){
             if(arr[i] != 0){
                 arr[index++] = arr[i];
             }
         }
         for(int num : arr){
             System.out.print(num + " ");
         }
    }/* Time Complexity: O(n²)
    Space Complexity: O(1)
    */

    //Two Pointer ⭐⭐⭐⭐⭐
    private static void TwoPointer(int[] arr){
        int c = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[c];
                arr[c] = arr[i];
                arr[i] = temp;

                c++;
            }
        }
        for(int num : arr){
            System.out.print(num + " ");
        }
    }/* Time Complexity: O(n)
    Space Complexity: O(1)
    */
}
























