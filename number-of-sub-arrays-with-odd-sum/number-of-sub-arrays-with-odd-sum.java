class Solution {
    public int numOfSubarrays(int[] arr) {
         int ans = 0;
        int[] dp = new int[arr.length];
        dp[0] =0;
        
        if(arr[0]%2==1)
            dp[0] =1;
        
        ans = dp[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]%2 == 0){
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = i - dp[i-1]+1;
            }
            ans= (ans + dp[i]) %1000000007;
        }
        
        return ans;

    }
}