class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n=profit.length;
        int dp[][]= new int [n][3];
        for(int i=0;i<n;i++){
            int job []=new int []{startTime[i],endTime[i],profit[i]};
            dp[i]= job;
        }
        
        Arrays.sort(dp, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
       TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(dp[0][1], dp[0][2]);
		int max = dp[0][2];
		for (int i = 1; i < n; ++i) {
			Integer index = treeMap.floorKey(dp[i][0]);
			if (index == null) {
				max = Math.max(max, dp[i][2]);
			} else {
				max = Math.max(max, treeMap.get(index) + dp[i][2]);
			}
			treeMap.put(dp[i][1], max);
		}
		return max;
}
}