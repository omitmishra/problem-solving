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
    int max=0;
    public int longestUnivaluePath(TreeNode root) {
        //max = 0;
        longestPath(root);
        return max;
    }
    
    public int longestPath(TreeNode root) {
        // Base case: if null node, return 0
        if (root == null) {
            return 0;
        }
        // Get the max length from left and right
        int l=longestPath(root.left);
        int r=longestPath(root.right);
        int L=0;
        int R=0;
        if(root.left!=null && root.val==root.left.val)
            L=l+1;
        
        if(root.right!=null && root.val==root.right.val)
            R=r+1;
         max=Math.max(max,L+R);
        return Math.max(L,R);
    }  

}