class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time=duration;
        if(timeSeries.length==0)
            return 0;
        for(int i=0;i<timeSeries.length-1;i++){
            int diff=timeSeries[i+1]-timeSeries[i];
            
            if (diff>duration){
                time=time+duration;
                
            }else{
                time=time+diff;
            }
        }
        
        return time;
    }
}