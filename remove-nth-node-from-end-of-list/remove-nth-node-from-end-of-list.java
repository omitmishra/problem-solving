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
    public ListNode removeNthFromEnd(ListNode head, int k) {
          ListNode curr=head;
        int n=0;
        while(curr!=null){
            curr=curr.next;
            n++;
        }
        if(n==1 || n==k)
            return head.next;
        
        curr=head;
        int i=0;
        ListNode temp=null;
         while(curr!=null){
             if(i+1==n-k){
                curr.next=curr.next.next;
                 break;
             }
            curr=curr.next;
            i++;
        }
      return head;  
    }

}