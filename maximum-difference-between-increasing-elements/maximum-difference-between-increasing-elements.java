class Solution {
    public int maximumDifference(int[] a) {
           int r = -1, i = 0;
        for (int j = 1; j < a.length; j++)
            if (a[i] < a[j])
                r = Math.max(r, a[j] - a[i]);
             else 
                i = j;
        return r;
}
    
}