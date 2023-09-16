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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode dummy = new ListNode(-999);
        ListNode t3 = dummy;
        int carry = 0;
        while(t1 !=null && t2 != null){
            int sum = t1.val + t2.val+carry;
            // int div = sum/10;
            // sum += div;
            if(sum/10 == 0){
                t3.next = new ListNode(sum);
            }
            else{
                t3.next = new ListNode(sum%10);
            }
            carry =sum/10;
            t1 = t1.next;
            t2 = t2.next;
            t3 = t3.next;
        }
        while(t1 != null && t2 == null){
            while(t1 != null){
                int sum = t1.val + carry;
                t3.next = new ListNode(sum %10);
                carry = (sum)/10;
                t3 = t3.next;
                t1 = t1.next;
            }
            
        }
        if(t1 == null && t2 != null){
            while(t2 != null){
                int sum = t2.val + carry;
                t3.next = new ListNode(sum %10);
                carry = (sum)/10;
                t3 = t3.next;
                t2 = t2.next;
            }
            
        }

        if(carry > 0){
            t3.next = new ListNode(carry);
        }
        
        return dummy.next;
        
    }
}