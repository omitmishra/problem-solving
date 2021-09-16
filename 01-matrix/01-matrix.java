class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<int[]>q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                      q.add(new int []{i, j});
                } else
                    mat[i][j] = Integer.MAX_VALUE;
                    
            }
        }
      int [][] directions = new int [][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
         while (!q.isEmpty()) {
            int [] current = q.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 || newX >= n || newY >= m || mat[newX][newY] <= mat[x][y] + 1)
                    continue;
                q.add(new int [] {newX, newY});
                mat[newX][newY] = mat[x][y] + 1;
            }
        }
        return mat;
    }

    }