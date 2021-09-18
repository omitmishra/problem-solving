class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
       if(costs == null) return 0;
         int len = costs.length;
		 
         //Sort the costs array by the profit margin
         Arrays.sort(costs,(a1,a2) -> Integer.compare(a1[0] - a1[1],a2[0] - a2[1]) );
         
         int lo = 0;
         int hi = len - 1;
         int min_cost = 0;
        
     while(lo < hi){
          min_cost += costs[lo][0] + costs[hi][1];
          lo ++;
          hi --;   
          }
        
     return min_cost;   
    }
    
    
}