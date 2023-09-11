/*
Question 1: Special Numbers
you are given a function:
    int  DesiredArray(int[] Arr, int N, int k):
The function accepts an array 'Arr' of size 'N' and an integer 'k'.
You have to find the 'K' smallest integers that are not divisible by any of the 'N' integers and return the sum of all 'K' integers.

Note: Array won't conatin 1.

Example:
Input:
    K: 4
    N: 5
    Arr: [2,3,4,5,6]
Output: 32
Explanation: First, K smallest non-divisible by Arr_i integers will be 1, 7, 11, 13. Hence the sum will be 32.

Sample input
    K:  4
    N:  4
    Arr : [3,6,9,12]
Sample Output
    12
*/

import java.util.Arrays;

public class q1 {
    public static boolean isDivisible(int num, int[] arr){
        for(int divisor: arr){
            if(num%divisor == 0){
                return true;
            }
        }
        return false;
    }
    public static int  DesiredArray(int[] Arr, int N, int k){
        Arrays.sort(Arr);
        int sum = 0;
        int num = 1;
        int count = 0;
        while (count < k){
            if(!isDivisible(num, Arr)){
                sum = sum + num;
                count++;
            }
            num++;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(DesiredArray(new int[]{2,3,4,5,6}, 5, 4));
        System.out.println(DesiredArray(new int[]{3,6,9,12}, 4, 4));
    }
}
