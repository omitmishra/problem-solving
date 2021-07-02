class Solution {
    public int reverse(int x) {
        int rem=0;
        int number=0;
        int z=x;
        if(x<0)
            x=Math.abs(x);
        while(x>0){
              if((long)number*10+x%10 > Integer.MAX_VALUE || (long)number*10+x%10 < Integer.MIN_VALUE)
                return 0;
             //  rem=x%10;
            number =number*10+x%10;
            
            x=x/10;
            
        }
        if(z<0){
            number=-number;
        }
        
        return number;
        
    }
}