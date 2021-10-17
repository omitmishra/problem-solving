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
     List<Integer> list = new ArrayList<>();
        int count=0;
    public int pathSum(TreeNode root, int sum) {
       
         helper(root,sum);
        return count;
    }
    
    private void helper(TreeNode node, int target){
        if (node == null) return ;
        
        list.add(node.val);
        int temp=0;
           for(int i=list.size()-1;i>=0;i--){
            temp+=list.get(i);
            if(temp==target)
                count++;
            
        }
        
        if(node.left!=null){
            helper(node.left,target);
            list.remove(list.size()-1);
        }
        if(node.right!=null){
        helper(node.right,target);
        list.remove(list.size()-1);
        }
        
        
      
    }
}