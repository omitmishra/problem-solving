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
    public ListNode[] splitListToParts(ListNode head, int k) {
     
        ListNode curr=head;
        int size=0;
        
        
        while(curr!=null){
            curr=curr.next;
            size++;   
        }
            
        ListNode [] res=new ListNode[k];
         if (head == null)
            return res;
        int extra=size%k;
        curr=head;
        int len = size / k;
        int j=0;
        
        while(curr!=null){
              ListNode temp1= curr;
              int diff = extra <= 0 ? 0 : 1;
              for(int i=0;i< len + diff - 1;i++)
                curr = curr.next;
            
             ListNode temp = curr.next;
             curr.next = null;
             curr = temp;
            
             res[j++] = temp1;
            
            //decrement the extra length
            extra--;

        }
        
        return res;
    }
}