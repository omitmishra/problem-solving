class Solution {
    public int jump(int[] nums) {
        int nextFarthest=0;
        int jumps=0;
        int farthest=0;
        int n= nums.length;
        if(n==1)
            return 0;
      for (int i = 0; i < nums.length; i++) {
		nextFarthest = Math.max(nextFarthest, i + nums[i]);

		if (nextFarthest >= n - 1) {
			jumps++;
			break;
		}

		if (farthest == i) {
			farthest = nextFarthest;
			jumps++;
		}
	}
        


	return jumps;
        
    }
}