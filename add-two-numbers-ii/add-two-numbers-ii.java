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
       Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        ListNode first = l1, second = l2;
        while (first != null){
            s1.push(first.val);
            first = first.next;
        }
        
        while (second != null){
            s2.push(second.val);
            second = second.next;
        }
        
        ListNode curr = null;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty() ||  carry != 0) {
            int one = s1.isEmpty() ? 0 : s1.pop();
            int two = s2.isEmpty() ? 0 : s2.pop();
            
            int sum = one + two + carry;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = curr;
            curr = newNode;
            carry = sum/10;
        }
        
        return curr;
    }   
}