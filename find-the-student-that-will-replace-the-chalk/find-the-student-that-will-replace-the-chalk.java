class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        while(k - chalk[i] >=0) {
            k -= chalk[i];
            i++;
            if(i==chalk.length)
                i = 0;
        }
        return i;
     }
    
}