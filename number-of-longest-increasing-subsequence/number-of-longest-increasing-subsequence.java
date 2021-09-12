class Solution {
    public int findNumberOfLIS(int[] nums) {
      if (nums.length == 0)
		return 0;
	int[] len = new int[nums.length]; // length of LIS ending at nums[i]
	int[] count = new int[nums.length]; // number of LISs ending at nums[i]
	Arrays.fill(len, 1);
	Arrays.fill(count, 1);
	int lisCount = 0;
	int maxLength = 0;
	for (int i = 0; i < nums.length; i++) {
		for (int j = 0; j < i; j++) {
			if (nums[i] > nums[j]) {
				if (len[i] == len[j] + 1) {
					count[i] += count[j];
				} else if (len[i] < len[j] + 1) {
					len[i] = len[j] + 1;
					count[i] = count[j];
				}
			}
		}
		if (maxLength == len[i]) {
			lisCount += count[i];
		} else if (maxLength < len[i]) {
			maxLength = len[i];
			lisCount = count[i];
		}
	}
	return lisCount;  
    }
}