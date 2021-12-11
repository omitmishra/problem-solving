class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
         long mod = (long)(Math.pow(10,9)+7);
        long left = Math.min(a,b);
        long right = (long)n*Math.min(a,b);
        long target = 0;
        int lcm = lcm(a,b);
        while(left < right){
            long mid = left + (right - left)/2;
            target = mid/a + mid/b - mid/lcm;
            if(target < n)
                left = mid + 1;
            else
                right = mid;
        }
        return (int)(left%mod);
    }
    public int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
    public int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    
    }
}