/*
Lettered Number

you are required to implement the follwing functio:
    int LetteredNumberSum(char[] str, int len);

The function accepts string 'str' ('str1' in case of Python) as its argument. Implement the function which returns sum of number equivalents of each letter in the given string 'str'.
The number equivalents are as follows:
    A = 1
    B = 10
    C = 100
    D = 1000
    E = 10000
    F = 100000
    G = 1000000
Assumption: 'str' contains upper case letters only
Note:
- Number equivalent for any letter other than (A,B,C,D,E,F,G) is 0
- Computed value lies with in integer range
- Return 0 if 'str' is null (None, in case of Python)

Example:
    Input:
        DCCBAA
    Output:
        1212
    Explanation: Sum = 1000 + 100 + 100 + 10 + 1 + 1 = 1212

    Sample input:
        GBCE
    Sample Output:
        1010110

 */
public class q4 {
    public static int LetteredNumberSum(char[] str, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            switch (str[i]) {
                case 'A':
                    sum += 1;
                    break;
                case 'B':
                    sum += 10;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 1000;
                    break;
                case 'E':
                    sum += 10000;
                    break;
                case 'F':
                    sum += 100000;
                    break;
                case 'G':
                    sum += 1000000;
                    break;
                default:
                    sum += 0;
                    break;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(LetteredNumberSum("DCCBAA".toCharArray(), 6));
        System.out.println(LetteredNumberSum("GBCE".toCharArray(), 4));
    }
}
