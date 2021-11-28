class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
           List<List<Integer>> res = new ArrayList<>();
        if(graph.length == 0)
            return res;
        List<Integer> path = new ArrayList<>();
        path.add(0);//adding starting 0th node initially
        dfs(graph,0,path,res);
        return res;
    }
    private void dfs(int[][] graph,int node,List<Integer> path,List<List<Integer>> res){
        if(node == graph.length - 1){ //node is index in graph i.e. each row or individual sub list
            res.add(new ArrayList(path));//when it reaches to end(graph.lenght-1) then add that path to res
            return;
        }
        for(int n : graph[node]){//traversing on each sublist or and finding path from that again
            path.add(n);
            dfs(graph,n,path,res);
            path.remove(path.size()-1);//backtracking
        }
    }
}