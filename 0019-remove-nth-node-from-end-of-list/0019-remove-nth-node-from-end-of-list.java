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
    
    // First Method
    /*
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
    */
    
    
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode reversedHead = reverse(head);
        
        ListNode tempReversedHead = reversedHead;
        
        for(int i = 1; i < n-1; i++){
            tempReversedHead = tempReversedHead.next;
        }
        
        if (n == 1){
            reversedHead = tempReversedHead.next;
        }
        
        tempReversedHead.next = tempReversedHead.next.next;
        
        ListNode ans = reverse(reversedHead);
        
        return ans;
        
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}