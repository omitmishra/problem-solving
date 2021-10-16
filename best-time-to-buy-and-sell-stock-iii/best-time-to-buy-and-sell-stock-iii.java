class Solution {
    public int maxProfit(int[] prices) {
         int min=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int ans=0;
        int ans1=0;
        for(int p:prices){
            min=Math.min(min,p);
            ans=Math.max(ans,p-min);
            min2=Math.min(min2,p-ans);
            ans1=Math.max(ans1,p-min2);
            
        }
        
        return ans1;

    }
}