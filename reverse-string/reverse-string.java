class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length;
        
        while(i<j){
            char temp=s[i];
            s[i]=s[j-1];
            s[j-1]=temp;
            i++;
            j--;
        }
      
    }
}