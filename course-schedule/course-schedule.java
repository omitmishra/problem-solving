class Solution {
    List<Integer> adj[];
    boolean  visited[];
    boolean  helper[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i]= new ArrayList<>();
         visited=new boolean[numCourses];
         helper=new boolean[numCourses];
        for(int arr[]:prerequisites){
            int a=arr[0];
            int b=arr[1];
            adj[b].add(a);
        }
        
        for(int j=0;j<numCourses;j++){
            if(visited[j]==false){
                if(iscycle(j))
                    return false;
            }
        }
        
       return true; 
}
   
      boolean iscycle( int i){
        visited[i] = true;        
        helper[i] = true;
        List<Integer> neighbours = adj[i];
        for(int k =0; k <neighbours.size(); k++){
            int curr = neighbours.get(k);
            if(helper[curr] == true)
                return true;
            if(visited[curr] == false){
                boolean ans = iscycle( curr);
                if(ans == true)  
                    return true;
            }   
        }   
        helper[i] = false;
        return false;
    }
}