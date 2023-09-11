/*
Sum of digits

You are required to implement the following function:
    int DifferenceSumOfDigits(int* arr, int n);

The function accepts an array 'arr' of 'n' positive integers as its argument. Let's suppose:
    f(x) = Sum of digits of an integer

You are required to calculate the value of the following:
    F1= [f(arr[0]) + f(arr[1]) + f(arr[2]) + ..........+ f(arr[n-1])] %10
    F2 = [(arr[0] + arr[1] + arr[2] + .........+ arr[n-1])] % 10
    F = F1 - F2

    and return the value of F.

Note: n > 0

Example:
    Input:
        arr: 11 14 16 10 9 8 24 5 4 3
        n: 10
    Output:
        -4
    Explanation:
        The value of F1 is (1 + 1) + (1 + 4) + (1 + 6) + (1 + 0) + (9) + (8) + (2 + 4) + (5) + (4) + (3) which is equal to 50 and (50 % 10) is 0 and value of F2 is (11 + 14 + 16 + 10 + 9 + 8 + 24 + 5 + 4 + 3) which is equal to 104 and (104 % 10 ) is 4 , the value of F is (0-4), hence -4 is returned.
*/
public class q9 {
    public static int DifferenceSumOfDigits(int[] arr, int n) {
        int f1 = 0;
        int f2 = 0;

        for (int i = 0; i < n; i++) {
            f1 += SumOfDigits(arr[i]);
            f2 += arr[i];
        }

        return (f1 % 10) - (f2 % 10);
    }

    public static int SumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(DifferenceSumOfDigits(new int[]{11, 14, 16, 10, 9, 8, 24, 5, 4, 3}, 10));
        System.out.println(DifferenceSumOfDigits(new int[]{1, 2, 3, 4, 5}, 5));
    }
}
