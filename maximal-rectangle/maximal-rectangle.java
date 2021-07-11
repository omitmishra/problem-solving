class Solution {
    public int maximalRectangle(char[][] matrix) {
         if(matrix.length==0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mtx = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='1'){
                    if(i==0 ){
                        mtx[i][j] = 1;
                    }
                    else {
                        mtx[i][j] = mtx[i-1][j] +1;
                    }
                }
                else{
                    mtx[i][j]=0;
                }
            }
        }
         int maxArea = 0;
       // int j=0;
        for(int i=0; i<m; i++){
            maxArea = Math.max(maxArea, largestRectangleArea(mtx[i]));
        }
        return maxArea;
    }
     public static  int largestRectangleArea(int[] heights) {
      int answer = 0;
        for(int i = 0; i < heights.length; i++){
            int currentHeight = heights[i];
            int left = i, right = i;
            while(left >= 0 && heights[left] >= currentHeight)
                left--;
            while(right < heights.length && heights[right] >= currentHeight)
                right++;
            answer = Math.max(answer,((right -1) - (left + 1) + 1 )*currentHeight );
            
        }
        
        return answer;
   
    }
}