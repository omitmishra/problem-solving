class Solution {
    public String convertToTitle(int columnNumber) {
      StringBuilder sb=new StringBuilder();
       while(columnNumber>0) {
           int rem=columnNumber%26;
           if(rem==0){
               sb.append('Z');
               columnNumber=(columnNumber/26)-1;
           }
           else
           {
              sb.append((char)('A'+rem-1));
              columnNumber/=26; 
           }
       }
        return sb.reverse().toString();
    }
}