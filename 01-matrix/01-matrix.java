class Solution {
    public int[][] updateMatrix(int[][] matrix) {
      
        int m = matrix.length;
        int n = matrix[0].length;
        
        int res[][] = new int[m][n];
        for(int[] r : res) Arrays.fill(r,Integer.MAX_VALUE);
        Queue<int[]> Q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1) continue;
                res[i][j] = 0;
                Q.add(new int[]{i,j});
            }
        }
        
        int dir[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
     
        while(!Q.isEmpty()){
            int[]cell = Q.poll();
            int curr_x = cell[0], curr_y = cell[1];
            for(int d[] : dir){
                int x = curr_x + d[0]; //neigbour x
                int y = curr_y + d[1]; //neighbour y
                if(x< 0 || y< 0 || x >= m || y >= n ||  (res[x][y] < res[curr_x][curr_y]+1)) continue;
                res[x][y] = res[curr_x][curr_y]+1;
                Q.offer(new int[]{x,y});
            }
        }
        return res;
    }
}