class Solution {
    
    PriorityQueue<Integer> minHeap =  new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        for(int i=0;i<nums1.length;i++){
            addNum(nums1[i]);
        }
          for(int j=0;j<nums2.length;j++){
            addNum(nums2[j]);
        }
        return findMedian();
    }
 
   
 
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
 
        if(minHeap.size()<maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }
 
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}