class Solution {
  public int numIslands(char[][] grid) {
        int count = 0;
        boolean visited[][]=new boolean [grid.length][grid[0].length];
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] == '1' && visited[i][j]==false){
                    count++;
                    dfs(grid, i, j,visited);
                }
            }
        }
        return count;
        
    }
        public void dfs(char[][] grid,int row,int col,boolean visited[][]){
        if(row<0 || col<0 || row>= grid.length || col>= grid[0].length || grid[row][col]=='0' || visited[row][col]){
            return;
        }
        visited[row][col]=true;
        dfs(grid, row+1, col,visited);
        dfs(grid, row, col+1,visited);
        dfs(grid, row-1, col,visited);
        dfs(grid, row, col-1,visited);
       // return;
    }
}
