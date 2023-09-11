import java.util.HashSet;
import java.util.Set;

/*
Marching People

Infinite number of people are crossing a 2-D plane.They march in such a way that each integral x coordinate will have exactly one person who moves along it in positive y direction, starting form(x,0).
You have to implement the following functions:
    int MaximumBarrier(int n, int** barrier);

The function takes an integer matrix 'barrier' having 'n' rows and '3' columns where n denotes the number of barriers. The ith barrier is defined by (xi, yi,di), which means that the barrier is blocking all the people who want to pass through points lying on line segment connecting(xi,yi) and (xi+di,yi). Once a person encounters a barrier, he stops moving.
Given all the barriers, your task is to find the total number of people who will be blocked at some point in their march.

Assumption:
    n>0
    Length of barrier (d) >0
Notes:
- Overlapping of barriers is possible.
- Do not use extra memory.

Example:
Input:
    n:2
              x    y   d
Barrier 1 :   2    3   3
Barrier 2 :   4    6   4

Output:
    7

// Check the link https://leetcode.com/discuss/interview-question/3694490/Accenture-OA-(Cognitive-and-Technical-Assessment-2023)-Questions-and-Answers
to see the image of the problem
*/
public class q11 {
    int MaximumBarrier(int n, int[][] barrier){
        Set<Integer> a = new HashSet<>();
        for (int[] i : barrier) {
            for (int j = i[0]; j <= i[0] + i[2]; j++) {
                a.add(j);
            }
        }
        return a.size();

    }
    public static void main(String[] args) {

    }
}
