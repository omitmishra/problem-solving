class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> sortedList = new ArrayList<>();
        Integer[] res = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            int left = 0, right = sortedList.size();
            while(left < right) {
                int mid = left + (right - left) / 2;
                if (sortedList.get(mid) >= nums[i])
                    right = mid;
                else 
                    left = mid + 1;
            }
            res[i] = right;
			
			// !Watch out, for .add it's O(n) time complexity
            sortedList.add(right, nums[i]);
        }
        return Arrays.asList(res);
    }
}