class Solution {
    public boolean judgeCircle(String moves) {
        int ans=0;
        int ans1=0;
        for(char c:moves.toCharArray()){
            if(c=='U'){
                ans++;
            }else if(c=='D'){
                ans--;
            }else if(c=='R'){
                ans1++;
            }else{
                ans1--;
            }
        }
        
        if(ans==0 && ans1==0)
            return true;
        
        return false;
    }
}