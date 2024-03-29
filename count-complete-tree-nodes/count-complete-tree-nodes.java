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
    public int countNodes(TreeNode root) {
          int count = 0;
     if(root == null) return 0;
     Deque<TreeNode> queue = new LinkedList<>();
     queue.offer(root);
     while (!queue.isEmpty()) {             
         int size = queue.size();
         for (int i = 0; i < size; i++) {
             TreeNode node = queue.pollFirst();
             count++;
             if (node.left != null) 
                 queue.offer(node.left);
             if (node.right != null) 
                 queue.offer(node.right);
         }
     }
     return count;         
    }
}