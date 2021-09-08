class Solution {
    public int uniqueLetterString(String S) {
        int M = 1000000007;
        int[] cur = new int[128];
        int[] prev = new int[128];
        Arrays.fill(cur, -1);
        Arrays.fill(prev, -1);
        int count = 0;
        long sum = 0;
        for (int i = 0; i < S.length(); i++) {
            int k = S.charAt(i);
            count += i - cur[k] - (cur[k] - prev[k]);
            prev[k] = cur[k];
            cur[k] = i;
            sum = (sum + count) % M;
        }        
        return (int)sum;
    }
}