/*
Add Alternate Nodes in Linked List

There is a singly linked list represented by the following structure:

struct node
{
   int data;
   struct Node* next;
};
Implement the following function:
    struct Node* AddAlternateNodes(struct Node* head);

The function accepts a pointer to the start of the linked list , 'head' as its argument . Implement the function to modify the given list in such a way that origin added to the value of next to the next node and return the modified list.

Note:
-  Return null if list is null, In case of python if list is None return None.
- Do not create new linked list , just modify the input linked list
- 1st and 2nd node values remain unchanged

Example:
Input:
    head: 1-> 2 -> 3 -> 4 -> 5 -> 6 -> 7
Output:
    1 -> 2 -> 4 -> 6 -> 8 -> 10 -> 12

Explanation:

- Adding original value of the node to its next to next node,
- Replace value of '3' with 1 + 3 = 4
- Replace value of '4' with 2 + 4 = 6
- Replace value of '5' with 3 + 5 = 8
- Replace value of '6' with 4 + 6 = 10
- Replace value of '7' with 5 + 7 = 12
- Thus obtained linked list is 1 -> 2 -> 4 -> 6 -> 8 -> 10 ->12

The custom input format for the above case:
    7
    1 2 3 4 5 6 7
    (The first line represents the number of nodes, the second line represents the linked list)

Sample input:
    head : 2 -> 1 -> 9 -> 2
Sample output:
    2 -> 1 -> 11 -> 3
*/
public class q2 {
    public static class Node {
        int val;
        Node next;
        Node(int x) { val = x; }

        public void print(){
            Node curr = this;
            while(curr != null){
                System.out.print(curr.val + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }

    public static Node AddAlternateNodes(Node head){
        if(head == null || head.next == null){
            return head;
        }
        // Set up pointers
        // Take 3 pointers
        Node prevPrev = head;
        Node prev = head.next;
        Node curr = head.next.next;

        // no change to first 2 nodes
        Node newHead = new Node(prevPrev.val);
        Node newCurr = newHead;
        newCurr.next = new Node(prev.val);
        newCurr = newCurr.next;

        while (curr != null){
            // newCur = prevPrev + curr
            newCurr.next = new Node(prevPrev.val + curr.val);
            newCurr = newCurr.next;
            if(curr.next == null){
                break;
            }
            // move pointers by 1
            prevPrev = prevPrev.next;
            prev = prev.next;
            curr = curr.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node input1 = arrToLL(new int[]{1,2,3,4,5,6,7});
        Node input2 = arrToLL(new int[]{2,1,9,2});
        Node output1 = AddAlternateNodes(input1);
        Node output2 = AddAlternateNodes(input2);
        output1.print();
        output2.print();
    }

    public  static Node arrToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node curr = head;
        for(int i = 1; i < arr.length; i++){
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }


}
