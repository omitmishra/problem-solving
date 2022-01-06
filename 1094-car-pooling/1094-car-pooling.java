class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int locations[] = new int[1001];
          for (int[] t: trips){
            int num_passengers = t[0];
            int start = t[1];
            int end = t[2];
            locations[start]+= num_passengers;
            locations[end]-= num_passengers;
          }
           int count=0;
            for (int i=0;i<1000;i++){
                count+=locations[i];
                if(count>capacity)
                    return false;
            }
            return true;
     }      
}