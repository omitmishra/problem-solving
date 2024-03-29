class Solution {
    public boolean canPartition(int[] nums) {
              int sum = 0;
        for (int number : nums)
            sum += number;
        if (sum % 2 != 0)
            return false; // this is the first condition to check
        // now the main thing to note is that if we can make a subset with subsetSum = sum / 2, then surely the other
        // subset can also make the subsetSum = sum / 2;
        // ie we make 2 subsets s1, s2. If we make s1 = totalSum / 2, then it is sure that the next subset s2 will make
        // subsetSum = totalSum / 2, so we can return true.
    
        int neededSum = sum / 2;
        // now we form a bool dp array
        boolean [][] dp = new boolean[nums.length + 1][neededSum+1];
        // subset sum problem
        for (int i=0; i<=nums.length; i++) {
            for (int j=0; j<=neededSum; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = false;
                else if (nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else if (nums[i-1] == j)
                    dp[i][j] = true;
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
            }
        }
        return dp[nums.length][neededSum];
    }
}