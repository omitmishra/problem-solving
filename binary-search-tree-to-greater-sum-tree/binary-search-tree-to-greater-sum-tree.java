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
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
         g(root);
        
        return root;
    }
    
    void g(TreeNode root){
        if(root==null)
            return;
        
        g(root.right);
        sum=sum+root.val;
        root.val=sum;
        g(root.left);
    }
}