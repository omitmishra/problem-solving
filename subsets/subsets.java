class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		List cur = new ArrayList<>();
		backTrack(nums, ans, cur, 0);
		return ans;
	}

	public void backTrack (int[] nums, List<List<Integer>> ans, List<Integer> cur, int start) {
		ans.add(new ArrayList<>(cur));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) continue;
			cur.add(nums[i]);
			backTrack(nums, ans, cur, i + 1);
			cur.remove(cur.size() - 1);
		}

    }
}