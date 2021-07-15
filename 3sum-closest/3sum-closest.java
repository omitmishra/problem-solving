class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //int n=nums.length;
       // int i=0;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
          int j=i+1;
          int n=nums.length-1;
            while(j<n){
                int sum=nums[i]+nums[j]+nums[n];
                int d=Math.abs(target - sum) ;
                if(Math.abs(diff)>d){
                    diff=target-sum;
                }
                 if (sum > target) {
                    n--;
                }
                else {
                    j++;
                }
            }
            
        }
          return (target-diff);
        
    }
}