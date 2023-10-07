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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        ListNode temp1 = head;
        int c = 0;
        while(temp != null){
            temp = temp.next;
            c++;
        }
        int arr[] = new int[c];
        int arr1[] = new int[c];

        for(int i = 0 ; i < arr.length ;i++){
            arr[i] = temp1.val;
            arr1[i] = temp1.val;
            temp1 = temp1.next;
        }

        for(int i = 0 ; i < arr.length -1;i = i+2){
            
            arr[i+1] = arr1[i];
            arr[i] = arr1[i+1];
        }

        for(int i = 0; i < arr.length;i++){
            System.out.println(arr[i]);
        }

        ListNode ans1 = head;
        
        for(int i = 0 ; i < c;i++){
            ans1.val = arr[i];
            ans1 = ans1.next;
        }


        return head;
    }
}