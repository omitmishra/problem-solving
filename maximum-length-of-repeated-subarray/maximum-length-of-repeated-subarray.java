class Solution {
    public int findLength(int[] A, int[] B) {
         int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
     
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    if(i==0 || j==0)
                         memo[i][j]=1;    
                    else
                         memo[i][j] = memo[i-1][j-1] + 1;
                    if (ans < memo[i][j]) 
                        ans = memo[i][j];
                }
            }
        }
        return ans; 
    }
}