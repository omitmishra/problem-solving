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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
    if (root == null) {return;}
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        if (right != null) 
        {
            stack.push(right);
        }
        if (left != null) 
        {
            stack.push(left);
        }
        if (left != null) {
            node.right = left;
        } else {
            node.right = stack.isEmpty()? right: stack.peek();
        }
    } 
    }
}