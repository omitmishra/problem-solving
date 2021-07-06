class Solution {
    public int minimumSwap(String s1, String s2) {
         int x=0,y=0;
        for(int i = 0; i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i)=='x')
                    x++;
                else 
                    y++;
            }
        }
        if(x%2==0 && y%2==0)
            return (x+y)/2;
        else  if(x%2==1 && y%2==1)
            return (x+y)/2 +1;
        return -1;
    }
}