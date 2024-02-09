/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode oddHead = null;
        ListNode oddNode = null;
        ListNode evenHead = null;
        ListNode evenNode  = null;
        int data = 0;

        while( head != null){
            data += 1;
            if(data%2 != 0){
                if(oddHead == null){
                    oddHead = head;
                    oddNode = head;
                }else{
                    oddNode.next = head;
                    oddNode = oddNode.next;
                }
            }
            else{
                if(evenHead == null){
                    evenHead = head;
                    evenNode = head;
                }else{
                    evenNode.next = head;
                    evenNode =evenNode.next;
                }
            }
            head = head.next;
        }

        if(oddHead == null){
            return evenHead;
        }
        else{
            oddNode.next = evenHead;
        }

        if(evenNode != null){
            evenNode.next = null;
        }
        return oddHead;
    }
}