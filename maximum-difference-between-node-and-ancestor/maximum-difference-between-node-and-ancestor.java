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
        dfs(root,new LinkedList<>());
        return max;
    }
    private void dfs(TreeNode root,LinkedList<Integer> list){
        if(root == null)
            return ;
        
        for(int x : list){
            max = Math.max(max,Math.abs(x-root.val));
        }
        
        list.add(root.val);
        
        dfs(root.left,list);
        dfs(root.right,list);
        
        list.pollLast();  
    }
}