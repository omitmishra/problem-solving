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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return null;
        if(root.val < low)
            return trimBST(root.right , low , high);
        else if(root.val > high)
            return trimBST(root.left , low , high);
        else{
            TreeNode now = root;
            TreeNode left = trimBST(root.left , low , high);
            TreeNode right = trimBST(root.right , low , high);
            now.left = left;
            now.right = right;
            return now;
        }
    }
}