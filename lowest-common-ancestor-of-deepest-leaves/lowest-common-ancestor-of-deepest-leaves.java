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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
           return get(root,1,getH(root));
        
    }
    
    
    TreeNode get(TreeNode root,int h,int H){
        if(root==null)
            return null;
        
        if(h==H){
            return root;
        }
        
        TreeNode l=get(root.left,h+1,H);
        TreeNode r=get(root.right,h+1,H);
        if(l != null && r!= null) 
            return root;
        return l==null?r:l;
    }
    
    
    
    
    int getH(TreeNode root){
        if(root==null)
            return 0;
        int l=getH(root.left);
        int r=getH(root.right);
        
        return Math.max(l,r)+1;
    }
}