/*
Fine Number

You are given a function:
    int FineNumber(int* a, int* b, int n, int m);

The function accepts two arrays 'a' and 'b' of size 'n' and 'm' respectively. Implement the function to compute a fine number and return the same.
A fine number is the greatest number that can be obtained by taking the difference of two numbers such that one of the two numbers is taken from array 'a' and the other is taken from array 'b'.

Example:
    Input:
    n: 5
    m: 6
    a: 1 2 3 4 5
    b: 10 12 34 2 4 89

    Output:
    88

    Explanation: Here, the greatest difference is between a 1 from array 'a' and 89 from array 'b'.

    Sample input
     n: 4
     m: 3
     a: 6 7 8 11
     b: 3 1 2
    Sample output
     10
*/
public class q7 {
    public static int FineNumber(int[] a, int[] b, int n, int m) {
        int max = Math.abs(a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if (Math.abs(a[i] - b[j]) > max) {
                    max = Math.abs(a[i] - b[j]);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(FineNumber(new int[]{1, 2, 3, 4, 5}, new int[]{10, 12, 34, 2, 4, 89}, 5, 6));
        System.out.println(FineNumber(new int[]{6, 7, 8, 11}, new int[]{3, 1, 2}, 4, 3));
    }
}
