class Solution {
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        int count=1;
        int n=chars.length;
        if (n==1)
            return n;
     for(int i=0;i<chars.length-1;i++){
         if(chars[i]==chars[i+1]){
             count++;
         }else{
             sb.append(chars[i]);
             if(count!=1)
             sb.append(count);
             count=1;
         }
         if(i+1==chars.length-1){
             if(chars[i]!=chars[n-1]){
                 sb.append(chars[n-1]);
             }else{
                 sb.append(chars[i]);
                 sb.append(count);
             }
         }
        
     }
         //sb.append(chars[i]);
        // sb.append(count);
          for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
       // System.out.print(sb);
        return sb.length();
     
    }
}