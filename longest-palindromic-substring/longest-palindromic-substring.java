class Solution {
   public String longestPalindrome(String A) {
    String ans = "";
    for(int i = 0; i < A.length(); i++)
    {
        String st1 = substring(i, i, A);
        String st2 = substring(i, i+1, A);
        
        String st3 = st1.length() > st2.length() ? st1 : st2;
        if(st3.length() > ans.length())
            ans = st3;   
    }
    return ans;
}

public String substring(int l,int r, String s){
    while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
        l--; 
        r++;
    }
    return s.substring(++l, r);
}  
}