class Solution {
    public void sortColors(int[] nums) {
      //  Arrays.sort(nums);
        int mid=0;
        int st=0;
        int en=nums.length-1;
        
        while(mid<=en){
            if(nums[mid]==0){
                int temp=nums[st];
                nums[st]=nums[mid];
                nums[mid]=temp;
                st++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                 int temp=nums[en];
                nums[en]=nums[mid];
                nums[mid]=temp;
                en--;
            }
        }
    }
}