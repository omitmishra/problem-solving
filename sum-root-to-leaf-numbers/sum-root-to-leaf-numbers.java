/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        sumUtil(root,0);
        return totalSum;
    }
    
    public void sumUtil(TreeNode root, int num)
    {
        if(root==null)
            return;
        
        num = (num*10)+root.val;  
         if(root.left==null && root.right==null)
        {
            totalSum+= num;
        }
        sumUtil(root.left,num);        
        sumUtil(root.right,num);
       
    }
        
    }
