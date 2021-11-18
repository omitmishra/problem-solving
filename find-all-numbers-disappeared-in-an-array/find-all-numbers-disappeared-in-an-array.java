class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
          List<Integer> ans = new ArrayList<Integer>();
        
       for(int i = 0; i < nums.length; i++) {
           int idx = nums[i] > 0 ? nums[i] : -nums[i];
           nums[idx - 1] = nums[idx - 1] < 0 ? nums[idx - 1] : -nums[idx - 1];
       }
         System.out.println(Arrays.toString(nums));  
        
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] > 0) {
                ans.add(j + 1);
            }
        }
        return ans;

    }
}