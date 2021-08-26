

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	HashMap<TreeNode, Integer> hm = new HashMap();

	public int rob(TreeNode root) {

		if (root == null) {
			return 0;
		}
		if (hm.containsKey(root)) {
			return hm.get(root);
		}

		TreeNode left = root.left;
		TreeNode right = root.right;

// include
		int include = root.val + (left != null ? (rob(left.left) + rob(left.right)) : 0)
				+ (right != null ? (rob(right.left) + rob(right.right)) : 0);

//exclude
		int exclude = rob(left) + rob(right);
		int result = Math.max(include, exclude);
		hm.put(root, result);
		return result;
	}
}