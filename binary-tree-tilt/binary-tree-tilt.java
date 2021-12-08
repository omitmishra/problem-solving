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
    public int findTilt(TreeNode root) {
           int[] x=f(root);
        return x[0];
    }
    public int[] f(TreeNode root){
        if(root==null)
            return new int[]{0,0};
        int[] lt=f(root.left);
        int[] rt=f(root.right);
        int tiltsum=lt[0]+rt[0]+Math.abs(lt[1]-rt[1]);
        int sum=lt[1]+rt[1]+root.val;
        return new int[]{tiltsum,sum};

    }
}