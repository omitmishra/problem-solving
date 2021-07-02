class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
 
 
      //Size is less than 3 return empty List;
        if(nums==null || nums.length<3)
            return Collections.emptyList();
        
        Set<List<Integer>> resultSet=new HashSet<>();
		
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
          int j=i+1;
          int high=nums.length-1;
          while(j<high){
              int sum= nums[i]+nums[j]+nums[high];
              if(sum==0){
             resultSet.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[high])));
                  j++;
                  high--;
              }if(sum<0){
                  j++;
              }if(sum>0){
                  high--;
              }
          }  
        }
      return new ArrayList<>(resultSet);
    } 
}