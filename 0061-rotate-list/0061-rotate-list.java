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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }

        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len ++;
            temp = temp.next;
        }

        k = k % len;

        if(k == 0){
            return head;
        }

        int rotateLength = len - k;

        ListNode temp1 = head;
        ListNode temp1Dummy = temp1;

        for(int i = 1 ; i < rotateLength; i++){
            temp1Dummy = temp1Dummy.next;
        }

        ListNode temp2 = temp1Dummy.next;
        temp1Dummy.next = null;

        ListNode temp2Dummy = temp2;

        while(temp2Dummy.next != null){
            temp2Dummy = temp2Dummy.next;
        }
        temp2Dummy.next = temp1;

        return temp2;
    }
}