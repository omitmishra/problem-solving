class Solution {
    public int mySqrt(int x) {
         int l=1;
        int r=x;
        int ans=1;
        if(x <= 0) return 0;
        while(l<=r){
            
            int mid =(l+r)/2;
            
            if(mid>x/mid){
               r=mid-1;
            }else{
                ans=mid;
                l=mid+1;
            }
        }
        
        return ans;
  
    }
}