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

    public ListNode reverseLL(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode reversedSecondHalf = reverseLL(slow);

        // Compare the first half with the reversed second half
        ListNode tempHead = head;
        while (tempHead != null && reversedSecondHalf != null) {
            if (tempHead.val != reversedSecondHalf.val) {
                return false;
            }

            tempHead = tempHead.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        return true;
    }
}