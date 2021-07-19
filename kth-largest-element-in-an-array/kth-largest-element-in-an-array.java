class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for(int num : nums){
            pq.add(num);
            i++;
            if (i > k) 
                pq.poll();
        }
        
        return pq.peek();
    
    }
}