class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod=1;
        int ans=0;
        if (k <= 1)
            return 0;
        int left=0;
        for(int i=0;i<nums.length;i++){
            prod=prod*nums[i];
            
            while(prod>=k){
                prod=prod/nums[left];
                left++;
            }
            ans=ans+i-left+1;
        }
        
        return ans;
    }
}