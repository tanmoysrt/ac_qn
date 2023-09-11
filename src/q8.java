/*
Merge and Rearrange

You are given a function,
    char* MergeStrings(char* str1, char* str2);

The function accepts strings 'str1' and 'str2' as its arguments, Implement the function to generate a string by iterating through each character of given string.
- For i = 0, on comparing charecters at index 0 of input strings, smaller character is placed at index 0 and larger character is placed at index n-1.
- For i = 1, on comparing charecters at index 1 of input strings, smaller character is placed at index 1 and larger character is placed at index n-2.
- For i = k, on comparing charecters at index k of input strings, smaller character is placed at index k and larger character is placed at index n-k-1.
where k<n and n is the length of output string (Length of string1 + Length of string2).

Assumption: String contain lower case characters only.

Note:
- Character 'x' is smaller than 'y' since it occurs prior in alphabetical series.
- Return null if both the strings are null.
- Return other string if one of the string is null.
- Null refers to None in case of Python.
- If length of strings is not same, then rest of the characters are added on their original positions.

Example:
    Input:
        str1: are
        str2: denim

    Output:
        aeeimnrd

    Explaination:
        Iterations 1 to n( = 4 )

        i = 1 : a _ _ _ _ _ _ d (a<d)
        i = 2 : a e _ _ _ _ r d (e<r)
        i = 3 : a e e _ _ n r d (e<n)
        i = 4 : a e e i m n r d
        Thus, final output = aeeimnrd


    Sample input
         str1:  cape
         str2:  port
    Sample Output
        capetrop
*/
public class q8 {
    public static String MergeStrings(String str1, String str2) {
        char[] res = new char[str1.length() + str2.length()];
        int i = 0;
        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) < str2.charAt(i)) {
                res[i] = str1.charAt(i);
                res[res.length - i - 1] = str2.charAt(i);
            } else {
                res[i] = str2.charAt(i);
                res[res.length - i - 1] = str1.charAt(i);
            }
            i++;
        }

        while (i < str1.length()) {
            res[i] = str1.charAt(i);
            i++;
        }
        while (i < str2.length()) {
            res[i] = str2.charAt(i);
            i++;
        }

        return new String(res);
    }
    public static void main(String[] args) {
        System.out.println(MergeStrings("are", "denim"));
        System.out.println(MergeStrings("cape", "port"));
    }
}
