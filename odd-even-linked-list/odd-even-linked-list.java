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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode();
        ListNode temp=odd;
        ListNode even=new ListNode();
        ListNode ev=even;
        ListNode curr=head;
        int i=0;
        while(curr!=null){
            if(i%2==0){
                temp.next=curr;
                temp=temp.next;
            }
            else{
                ev.next=curr;
                ev=ev.next;
            }
            
            curr=curr.next;
            i++;
            
        }
    ev.next=null;
    temp.next=even.next;
        
        return odd.next;
        
    }
}