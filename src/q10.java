import java.util.Arrays;

/*
Small Number Problem

Implement the following function:
    int *  NextSmallerNumber(int a[], int m);

The function accepts an integer array 'a' of size m. Replace each number of array with nearest smaller number on its right in the array.

Assumption: All integers are > 0.

Note:
- Return null if array is null.
- Null refers to None in case of Python.
- Replace the number with '-1', if no smaller number is present on its right.

Example:
    Input:
        a: 3 2 11 7 6 5 6 1
    Output:
        2 1 7 6 5 1 1 -1

    Explanation: Every number is replaced with the 1st smaller number on its right, ('3' -> '2', '2' -> '1', '11' -> '7' , '7' -> '6', '6' ->'5', '5' -> '1', '6' -> '1' and '1' -> '-1'

    Sample input
        a: 10 5 4 5 3 2 1
    Sample Output
        5 4 3 3 2 1 -1
*/
public class q10 {
    public static int[] NextSmallerNumber(int[] a, int m){
        int[] result = new int[m];
        for(int i = 0; i < m; i++){
            result[i] = findNextSmaller(a, m, i);
        }
        return result;
    }

    public static int findNextSmaller(int[] a, int m, int index){
        int result = -1;
        for(int i = index + 1; i < m; i++){
            if(a[i] < a[index]){
                result = a[i];
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(NextSmallerNumber(new int[]{3, 2, 11, 7, 6, 5, 6, 1}, 8)));
        System.out.println(Arrays.toString(NextSmallerNumber(new int[]{10, 5, 4, 5, 3, 2, 1}, 7)));
    }
}
