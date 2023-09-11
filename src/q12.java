/*
Number of Cards

Arrangement of cards used for building pyramids are shown in the following image:
// Check the link https://leetcode.com/discuss/interview-question/3694490/Accenture-OA-(Cognitive-and-Technical-Assessment-2023)-Questions-and-Answers to see the image of the problem

you are required to implement the following function:
    int CardsPyramid(int n);

The function accepts an integer 'n' as an argument. The integer 'n' denotes level of pyramid. You are required to calculate the number of cards. required to build a pyramid of level 'n' and return the number of cards % 1000007.

Note:
    Return -1, if 'n' =0
Assumptions:
    The number of cards required to build a pyramid of level 1 are 2

Input:
    n: 2
Output:
    7
Explaination:
    Cards required to build a pyramid of level 1 are 2, adding 1 more level to the pyramid will require 5 more cards, thus a total of 7 cards are needed to build a pyramid of level 2. Hence 7 % 1000007 is returned.

Sample input
    n: 3
Sample Output
    15
 */
public class q12 {
    public static int CardsPyramid(int n){
        if (n == 0) return -1;
        int ans = 2;
        for (int i = 2; i <= n; i++) {
            ans += 3 * (i - 1) + 2;
        }
        return ans % 1000007;
    }
    public static void main(String[] args) {
        System.out.println(CardsPyramid(3));
        System.out.println(CardsPyramid(2));
    }
}
