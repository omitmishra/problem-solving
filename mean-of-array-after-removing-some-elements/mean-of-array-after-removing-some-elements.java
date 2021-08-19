class Solution {
    public double trimMean(int[] arr) {
        
           Arrays.sort(arr);      //sort
        int len = arr.length;
        int start = len / 20; //get the first 5%
        int end = len-start;  // get the last 5%
        double sum = 0;
        for(int i=start; i<end; i++) 
            sum += arr[i]; //add everything in the range
        return sum / (len - (2 * start));  //return the mean for the count in the range
    }
}