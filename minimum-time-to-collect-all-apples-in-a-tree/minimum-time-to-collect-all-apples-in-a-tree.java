class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
       List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(i,new ArrayList<>());
        for(int arr[]:edges){
            int e=arr[0];
            int v=arr[1];
            list.get(e).add(v);
            list.get(v).add(e);
        }
        boolean vis[]=new boolean [n];
        return  dfs(list,0,vis,hasApple);
        
      //  return -1;
        
    }
    
    int dfs(List<List<Integer>> list,int n,boolean vis[], List<Boolean> hasApple){
        
        vis[n]=true;
        int count=0;
        List<Integer> li=list.get(n);
        for(int i:li){
            if(vis[i]==false){
                vis[i]=true;
            count=count+dfs(list,i,vis,hasApple);
            }
        }
         if ((count>0 || hasApple.get(n)) && n != 0)
            count += 2;
           // count += 2;
        
        return count;
        
    }
}