class Solution {
      public int[][] memo;
    public int uniquePaths(int m, int n) {
         memo = new int[m][n];
       return getpath(0,0,m,n,memo);
    }
    
    int getpath(int x,int y ,int m ,int n,int[][] memo){
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(i==0 || j==0)
                   memo[i][j]=1;
               
               else 
                   memo[i][j]=memo[i][j-1] + memo[i-1][j];
           
       }
           
       }
        
          return memo[m-1][n-1];
    }
}