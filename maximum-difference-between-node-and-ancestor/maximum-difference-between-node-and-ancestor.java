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
    public int maxAncestorDiff(TreeNode root) {
         // int max = 0;
        helper(root,root.val,root.val);
        return max;
    }
    
    private void helper(TreeNode node, int curMax, int curMin){

    if(node ==null){
        return;
    }
    curMax = Math.max(curMax, node.val);
    curMin = Math.min(curMin, node.val);
    max= Math.max(max, Math.abs(curMin- curMax));
    helper(node.left,curMax, curMin);
    helper(node.right,curMax, curMin);
    return;
    }
}