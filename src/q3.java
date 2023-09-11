import java.util.Arrays;

/*
Distinct and Duplicate Integers

Implement the following function:
    def AddDistinctDuplicate(a,b,c,d):
The function accepts four integers 'a','b','c' and 'd' as its argument . Implement the function to find the sum of distinct numbers and subtract the duplicate number and return the difference (sum of distinct number - duplicate number).

- For sum of distinct number add all number that appears only once
- For duplicate number subtract the duplicate number only once

Notes: All computed values lie within integer range
Examples:
    Input:
        a:5
        b:4
        c:4
        d:9
    Output:
        10
    Explanation: 2 distinct number are 5 and 9. Sum of distinct number = 5+9 = 14. Duplicate number = 4. Difference = Sum of distinct numbers - Duplicate number = 14 - 4 = 10. Thus, output is 10.

Sample input
    a: -1
    b:  3
    c:  8
    d: -6
Sample Output
    4
*/
public class q3 {
    public static int AddDistinctDuplicate(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        int duplicate = 0, distinct = 0, lastval = 0, count = 0;

        for (int i = 0; i < arr.length; i++) {
            // add first element
            if(i == 0){
                distinct += arr[i];
                lastval = arr[i];
                count = 1;
                continue;
            }
            // if duplicate
            if(arr[i] == lastval) {
                // if it's second occurence,
                // remove it from distinct and add it to duplicate
                if(count == 1) {
                    duplicate += arr[i];
                    distinct -= arr[i];
                }
                count++;
            } else {
                // if not duplicate, add it to distinct
                // and update lastval and reset count
                distinct += arr[i];
                lastval = arr[i];
                count = 1;
            }
        }
        return distinct - duplicate;
    }
    public static void main(String[] args) {
        System.out.println(AddDistinctDuplicate(-1, 3, 8, -6));
        System.out.println(AddDistinctDuplicate(5, 4, 4, 9));
    }
}
