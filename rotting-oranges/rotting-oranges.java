class Solution {
    public int orangesRotting(int[][] grid) {
        int f=0;
        Queue<int[]>q=new LinkedList();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int []{i,j});
                }else if (grid[i][j]==1){
                    f++;
                }
            }
        }
        int ans=0;
        int [][] dir= {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty() && f>0){
            ans++;
            
            int size=q.size();
            while(size>0 ){
                int []xy=q.poll();
                for(int d[]:dir){
                int x=xy[0]+d[0];
                int y=xy[1]+d[1];
                if(x<0 ||x>=grid.length || y<0 || y>=grid[0].length ||  grid[x][y] == 2 || grid[x][y] == 0)
                    continue;
                
                   q.add(new int []{x, y});
                    grid[x][y] = 2;
                    f --;
                    }
                size--;
        }
        
    }
        return f==0?ans:-1;
}
}