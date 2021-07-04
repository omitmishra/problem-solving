class Solution {
    public int trap(int[] height) {
       int n=height.length;
        
        int ans=0;
        int l[]=new int[n];
        int r[]=new int[n];
        int ma=0;
        for(int i=0;i<n;i++){
            ma=Math.max(ma,height[i]);
            l[i]=ma;
        }
        ma=0;
         for(int i=n-1;i>=0;i--){
            ma=Math.max(ma,height[i]);
            r[i]=ma;
        }
        
         for(int i=0;i<n;i++){
            ans+=Math.min(r[i], l[i])-height[i];
           // l[i]=ma;
        }
        
        return ans;
    }
}