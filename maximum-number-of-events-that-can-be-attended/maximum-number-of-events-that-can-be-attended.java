class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> (a[0]==b[0]) ? a[1]-b[1] : a[0]-b[0]);
        
        int res = 0; int i=0; int n=events.length;
        
        Queue<Integer> pq = new PriorityQueue();
        
        for(int d=1; d<=100000; d++) {
            while(i<n && events[i][0]==d) {
                pq.offer(events[i++][1]);    //add all events that CAN be attended on day d
            }
            
            while(!pq.isEmpty() && pq.peek()<d) {
                pq.poll();                   //remove all events which are already closed
            }
            
            if(!pq.isEmpty()) {
                pq.poll();
                res++;                      //Use Day d to attend event that closes first     TC: O(logn)
            }
        }
        
        return res;
    }
          
}