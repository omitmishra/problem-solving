class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> list = new ArrayList<int[]>();
        int st = intervals[0][0];
        int en = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (en>=intervals[i][0]) {
                en = Math.max(en, intervals[i][1]);
            } else {
                list.add(new int[]{st, en});
                st = intervals[i][0];
                en = intervals[i][1];
            }
        }
        list.add(new int[]{st, en});
        return list.toArray(new int[list.size()][2]); 
    }
}