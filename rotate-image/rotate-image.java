class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];                
                matrix[j][i]=t;
            }
        }
        
        for(int i=0;i<n;i++){
           int  k=matrix.length-1;
            for(int j=0;j<k;j++){
                int t=matrix[i][k];
                matrix[i][k]=matrix[i][j];
                matrix[i][j]=t;
                k--;
            }
        }
         
    }
}