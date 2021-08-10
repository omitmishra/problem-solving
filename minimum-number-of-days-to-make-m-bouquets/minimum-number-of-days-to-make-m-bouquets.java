class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int lo=Integer.MAX_VALUE;
        int hi=0;
        
        for(int i:bloomDay){
            lo=Math.min(i,lo);
            hi=Math.max(i,hi);
        }
        int nf=m*k;
        if(nf>bloomDay.length)
            return -1;
        
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
           int flowglow=getD(bloomDay,mid ,k);
            if(flowglow>=m){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
            
            
        }
     return lo;   
    }
        
      int  getD(int[] bloomDay,int days,int k){
            int flow=0;
          int adcount=0;
          for(int i:bloomDay){
              if(i<=days ){
                  flow++;
                 // adcount++;
              }else{
                 flow=0; 
              }
              
              if(flow==k){
                 adcount++; 
                  flow=0;
              }
          }
          
          return adcount;
        }

}