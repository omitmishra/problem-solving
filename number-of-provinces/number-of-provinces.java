class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean vis []=new boolean [isConnected.length];
        int cnt=0;
        for(int i=0;i<isConnected.length;i++){
            if(vis[i]==false){
                dfs(isConnected,vis,i);
                cnt++;
            }
            
        }
        return cnt;
    }
    
    void dfs(int [][] isConnected,boolean [] vis,int v){
        
        vis[v]=true;
        int arr[]=isConnected[v];
        for(int i=0;i<arr.length;i++){
            if(vis[i]==false && isConnected[v][i]==1){
                vis[i]=true;
                dfs(isConnected,vis,i);
            }
            
        }
        
    }
    
}