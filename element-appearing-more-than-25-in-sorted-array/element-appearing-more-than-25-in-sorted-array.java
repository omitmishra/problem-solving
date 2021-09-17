class Solution {
    public int findSpecialInteger(int[] arr) {
        int n=arr.length;
        int count=1;
        if(n==1)
            return arr[0];
        double ocur=.25*n;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]){
                count++;
            }else{
                count=1;
            }
            
            if(count>ocur){
                return arr[i];
            }
            
        }
        
        return -1;
    }
}