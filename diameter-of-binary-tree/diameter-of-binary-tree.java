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
      int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        return diameter-1;
    }
    
    private int postOrder(TreeNode root){
        if(root == null) return 0;
        int leftSize = postOrder(root.left);
        int rightSize = postOrder(root.right);
        int temp = Math.max( leftSize , rightSize)+1;
         int d = Math.max( temp,leftSize+rightSize+1);
         diameter= Math.max( diameter,d);
        
        return temp;
    }
}