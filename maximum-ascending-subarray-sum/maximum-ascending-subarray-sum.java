class Solution {
    public int maxAscendingSum(int[] nums) {
       int max_sum = nums[0];
        int current_sum = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i - 1] < nums[i])
            {
                current_sum = current_sum + nums[i];
                max_sum = Math.max(max_sum, current_sum);
            }
            else
            {
                max_sum = Math.max(max_sum, current_sum);
                current_sum = nums[i];
            }
        }
 
        return Math.max(max_sum, current_sum);   
    }
}