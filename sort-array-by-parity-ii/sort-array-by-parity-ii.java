class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int even=0,odd=1;
      int[] sort=new int[nums.length];
      for(int i:nums){
          if(i%2==0){
              sort[even]=i;
              even=even+2;}
          else{
              sort[odd]=i;
              odd=odd+2;
          }
      }
        return sort;

    }
}