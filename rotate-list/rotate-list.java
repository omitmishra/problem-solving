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
        if ( head == null || head.next == null || k <= 0) {
            return head;
        }
        
        ListNode lastNode = head;
        int listLength = 1;
        
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            listLength++;
        }
        
        lastNode.next = head;
        k %= listLength;
        int skipLength = listLength - k;
        ListNode lastNodeOfRotatedList = head;
        
        for (int i=0; i<skipLength - 1; i++) {
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;
        }
        
        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;
        
        return head;
    }
}