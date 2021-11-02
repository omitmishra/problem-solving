class Solution {
    public int uniquePathsIII(int[][] grid) {
        int row = grid.length; 
        int col = grid[0].length;
        int noOfNonObstacles = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 0)
                    noOfNonObstacles += 1;
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1)
                    return helper(grid, i+1, j, noOfNonObstacles) +
                    helper(grid, i-1, j, noOfNonObstacles) +
                    helper(grid, i, j-1, noOfNonObstacles) + 
                    helper(grid, i, j+1, noOfNonObstacles);
            }
        }
        return 0;
    }
    public int helper(int [][] grid, int i, int j, int noOfNonObstacles) {
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == -1 || grid[i][j] == 1)
            return 0;
        if (grid[i][j] == 2)  {
            if (noOfNonObstacles == 0)
                return 1;
            return 0;
        } // check if we reach the destination but still there are non obstacles unvisited
        if (noOfNonObstacles == 0)
            return 0;  // we didnt reach the destination but our non Obstacles are fully visited
        grid[i][j] = 1;  // let it denote visited
        int possibleWay1 = helper(grid, i+1, j, noOfNonObstacles-1);
        int possibleWay2 = helper(grid, i-1, j, noOfNonObstacles-1);
        int possibleWay3 = helper(grid, i, j-1, noOfNonObstacles-1);
        int possibleWay4 = helper(grid, i, j+1, noOfNonObstacles-1);
        grid[i][j] = 0; //for backtracking
        return possibleWay1 + possibleWay2 + possibleWay3 + possibleWay4;
    }
}