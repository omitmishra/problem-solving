class MedianFinder {
    PriorityQueue<Integer> pq=null;
    PriorityQueue<Integer> pq1=null;

    /** initialize your data structure here. */
    public MedianFinder() {
        pq=new PriorityQueue<Integer>();
         pq1=new PriorityQueue<Integer>((a,b)->(b-a));
        
    }
    
    public void addNum(int num) {
        pq.add(num);
        pq1.add(pq.poll());
        if(pq1.size()>pq.size()){
            pq.add(pq1.poll());
        }
    }
    
    public double findMedian() {
         if(pq.size() > pq1.size()){
            return pq.peek();
        }else {
            return (pq.peek()+pq1.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */