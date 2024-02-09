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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode ans = head;
        ListNode temp = head;
        
        int c = 0;
        
        while(temp != null){
            c++;
            temp = temp.next;
        }
        
        // System.out.println(c);
        c = c - n;
        for(int i= 1; i < c ;i++){
            ans = ans.next;
        }   

        if(c == 0){
            return head.next;
        }
        
        if(ans.next != null){
            ans.next = ans.next.next;
        }
        return head;
    }
}