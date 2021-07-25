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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
         List<TreeNode> list=new ArrayList<>();
        HashMap<String,Integer> hm=new HashMap<>();
        helper(root,hm,list);
        return list;
    }
    public String helper(TreeNode root,HashMap<String,Integer> hm,List<TreeNode> list){
        if(root==null){
            return "X";
        }
        String left=helper(root.left,hm,list);
        String right=helper(root.right,hm,list);
        String temp=root.val+" "+left+right;
        hm.put(temp,hm.getOrDefault(temp,0)+1);
        if(hm.get(temp)==2){
            list.add(root);
        }
        return temp;
    }
}