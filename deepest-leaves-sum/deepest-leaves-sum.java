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
    int ans=0;
    int max=0;
    public int deepestLeavesSum(TreeNode root) {
        int r= getH(root);
       // System.out.print(r);
        
        getSum(root,1,0,r);
        
        return ans;
        
    }
    int getH(TreeNode root){
        if(root==null)
            return 0;
        int l=getH(root.left);
        int r=getH(root.right);
        
        return 1+Math.max(l,r);
    }
    
    
    void getSum(TreeNode root ,int lev,int max,int r){
        if(root==null) return ;
        
        if(lev>=max){
            max=lev;
            if( max==r)
                ans=ans+root.val;
        }
        
        getSum(root.left,lev+1,max,r);
        getSum(root.right,lev+1,max,r);
        
    }
}