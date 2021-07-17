//    List<List<Integer>>  list =new ArrayList<>();
//          Map<Integer,List<Integer>>map=new HashMap<>();
//          List<Integer>  res =new ArrayList<>();
//         for(List<Integer> connection :connections ){
            
//             map.putIfAbsent(connection.get(0),new ArrayList<>());
//             map.putIfAbsent(connection.get(1),new ArrayList<>());
//             map.get(connection.get(0)).add(connection.get(1));
//             map.get(connection.get(1)).add(connection.get(0));
//         }
//         System.out.print(map);
//         for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
//             List<Integer> val=entry.getValue();
//             int key =entry.getKey();
//             if(val.size()==1){
//                  res =new ArrayList<>();
//                  res.add(key);
//                  res.add(val.get(0));
//                  list.add(res);
                
                
//             }
//         }
        
//         return list;
//     }

class Solution {
  List<List<Integer>> bridges;
    ArrayList<Integer>[] graph;
    int[] ids, low;
    int id;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //1. initialize global variables;
        bridges = new ArrayList<>();
        graph = new ArrayList[n];
        ids = new int[n];
        low = new int[n];
        id = 0;
        
        //2. build graph;
        buildGraph(connections);
        
        //3. find bridges;
        boolean[] visited = new boolean[n];
        dfs(visited, -1, 0);
        
        return bridges;
    }
    
    private void dfs(boolean[] visited, int parent, int i) {
        visited[i] = true; 
        ids[i] = low[i] = id++;
        
        for (int node : graph[i]) {
             if (node == parent)
                 continue;
            
            if (!visited[node]) {
                dfs(visited, i, node);
				
				//things below happen during backtracking
                low[i] = Math.min(low[i], low[node]);   
                if (ids[i] < low[node]) 
                    bridges.add(Arrays.asList(i, node));
            } else {
                low[i] = Math.min(low[i], ids[node]);
            }
        }
    }
    
    private void buildGraph(List<List<Integer>> connections) {
        for (int i = 0; i < graph.length; i++) 
            graph[i] = new ArrayList<>();
        for (int i = 0; i < connections.size(); i++) {
            int a = connections.get(i).get(0);
            int b = connections.get(i).get(1);
            graph[a].add(b);
            graph[b].add(a);
        }
    }

}