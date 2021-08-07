class Solution {
    public int lengthOfLongestSubstring(String A) {
          int n=A.length();
        int ans=0;
        StringBuilder sb=new StringBuilder();
        for(char c:A.toCharArray()){
            if(sb.indexOf(String.valueOf(c))==-1){
                sb.append(c);
                ans=Math.max(ans,sb.length());
            }else{
                int k=sb.indexOf(String.valueOf(c));
                sb.delete(0,k+1);
                 sb.append(c);
            }
        
        }
        System.out.print(sb.toString());
        return ans;
        
    }
}