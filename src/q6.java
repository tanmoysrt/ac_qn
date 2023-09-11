/*
Maximum Element And Its Index

You are given a function,
    Void MaxInArray(int arr[],int length);

The function accepts an integer array 'arr' of size 'length' as its argument. Implement the function to find the maximum element of the array and print the element and its index to the standard output (STDOUT) . The maximum element and its index should be printed in separate lines.

Notes:
- Array index start with 0.
- Maximum element and its index should be separated by a line in the output.
- Assume there is only 1 maximum element in the array.
- Print exactly what is asked, do not print any additional greeting messages

Example 1:
 23 45 82 27 66 12 78 13 71 86
Output:
 86
 9
Explanation: 86 is the maximum element of array at index 9.

Example 2:
 1 9 11 144 6 7 112 95
Output 2:
 144
 3
*/
public class q6 {
    public static void MaxInArray(int arr[], int length) {
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index);
        System.out.println();
    }
    public static void main(String[] args) {
        MaxInArray(new int[]{23, 45, 82, 27, 66, 12, 78, 13, 71, 86}, 10);
        MaxInArray(new int[]{1, 9, 11, 144, 6, 7, 112, 95}, 8);
    }
}
