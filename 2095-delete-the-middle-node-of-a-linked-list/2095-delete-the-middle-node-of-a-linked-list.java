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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode alternate  = head;
        ListNode ans = head;
        int count = 0;

        while(alternate != null){
            count ++ ;
            alternate = alternate.next;
        }

        count = count/2;

        // int c = 0;
        // while(ans.next != null){
        //     c++;
        //     if(c == count){
        //         ans.next = ans.next.next;
        //     }
        //     ans = ans.next;
        // }

        for(int i = 0 ; i  < count -1 ; i++){
            ans = ans.next;
        }
        ans.next = ans.next.next;
        return head;

    }
}