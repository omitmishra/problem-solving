class Solution {
    public int[] singleNumber(int[] nums) {
        
     int xor = 0, res1 = 0, res2 = 0;
        
        for(int num : nums)
            xor = xor ^ num;
        
        //Take leftmost most significant bit number
        int lsb = (xor & ~(xor - 1));
        
        for(int num : nums){
            if((num & lsb) != 0)
                res1 = res1 ^ num;
            else
                res2 = res2 ^ num;
        }
        
        return new int[]{res1, res2};
    }
}