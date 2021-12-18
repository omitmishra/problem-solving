class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
//          int cnt = 0;
//         Arrays.sort(digits);
//           Queue<Integer> q = new LinkedList<>();
//        // for(int i = 0; i < digits.length; i++)
         
        
//         for(int i = 0; i < digits.length; i++){
//             if (Integer.parseInt(digits[i])  <= n){
//                    q.offer(Integer.parseInt(digits[i]));
//                    cnt++;
//             }
//                // cnt++;
//         }
        
      
        
//         while (!q.isEmpty()){
//             Integer curr = q.poll();
//             for(int i = 0; i < digits.length; i++){
//                 int newVal = curr*10 + Integer.parseInt(digits[i]);
//                 if (newVal <= n){
//                     cnt++;
//                     q.offer(newVal);
//                 } else
//                     break;
//             }
//         }
//         return cnt;
        
         String maxnstr = Integer.toString(n);
        
        int lenDigs = maxnstr.length();
        int rslt = 0;
        for(int len = 1; len <= lenDigs; len++){
            rslt += helper(len, digits, maxnstr);
        }
        return rslt;
    }
    private int helper(int len, String[] digs, String max){
        if (max.equals("0"))
            return 0;
        
        if (len < max.length()){
            return (int)Math.pow(digs.length , len);
        }
        // if we get here len == max.length()
        // so only include if the first digit of resulting string
        // is less than max's first digit or their first digit is equal
        // but a subsequent digit of resulting string is less than max/s correspoding??
        int cnt = 0;
        for(int i = 0; i < digs.length; i++){
            char fchar = max.charAt(0);
            if (Integer.parseInt(digs[i]) < (fchar - '0')){
                cnt += helper(len-1, digs, max);
            } else if (Integer.parseInt(digs[i]) == (fchar - '0')){
                if (max.length() > 1){
                    // recurse it to next level with one less length and 
                    // with the left most character chopped off the max
                    cnt += helper(len-1, digs, max.substring(1));
                } else {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
}