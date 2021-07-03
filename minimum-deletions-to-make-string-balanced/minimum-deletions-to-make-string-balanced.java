class Solution {
    public int minimumDeletions(String s) {
         int bcnt = 0;
        int deleted = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'b') 
                bcnt++;
            else{
                deleted = Math.min(deleted+1,bcnt);
            }
        }
        return deleted;
        
    }
}