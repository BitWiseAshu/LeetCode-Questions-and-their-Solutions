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
// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         ListNode temp = head;
//         int c = 0;
//         while(temp != null){
//             temp = temp.next;
//             c++;
//         }

//         int []arr = new int[c];
//         int []arr1 = new int[c];

//         ListNode temp1 = head;
//         for(int i = 0 ; i < c ;i++){
//             arr[i] = temp1.val;
//             arr1[i] = temp1.val;
//             temp1 = temp1.next;
//         }


//         int round = c/k;
//         int n = k;
//         int help = n;
//         int p = 0;

//         for(int i = 0 ; i < round;i++){
//             for(int j = 0 ; j < k; j++){
//                 arr[p] = arr1[n-1];
//                 p++;
//                 n--;
//             }
//             n = help + k;
//             // p = help;
//             help = n;

//         }

//         ListNode ans = head;
//         for(int i = 0 ; i < c ;i++){
//             ans.val = arr[i];
//             ans = ans.next;
//         }
        
//         return head;
//     }
// }


























class Solution {
    
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp;

        while (curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        
        if(k == 1) return head;
        
        ListNode temp = head;
        ListNode temp1 = temp;
        
        ListNode nextHead;
        
        ListNode ans = new ListNode(-9999);
        ListNode tempAns = ans;
        
        int count = 1;
        while(temp1 != null){
            
            
            
            if(count == k){
                nextHead = temp1.next;
                
                if(nextHead == null){
                    tempAns.next = reverse(temp);
                    return ans.next;
                }
                temp1.next = null;
                count = 1;
                
                tempAns.next = reverse(temp);
                temp = nextHead;
                while(tempAns.next != null){
                    tempAns = tempAns.next;
                }
                
                temp1 = nextHead;
            }
            
            count ++;
            temp1 = temp1.next;
            
        }
        
        // if(count != k){
            tempAns.next = temp;
        // }
        
        // System.out.println(temp.val);
        
        return ans.next;
    }
}