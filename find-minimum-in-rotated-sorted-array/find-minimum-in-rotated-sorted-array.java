class Solution {
    public int findMin(int[] nums) {
         if(nums.length == 0) 
             return nums[0];
        int n=nums.length-1;
        int i=0;
        
        while(i<n){
            int mid=i+(n-i)/2;
            
            if(nums[mid]<nums[n])
                n=mid;
            else
                i=mid+1;
            
        }
        return nums[n];
    }
}