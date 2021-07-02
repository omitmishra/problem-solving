class Solution {
    public boolean isPalindrome(int x) {
         if (x < 0)
             return false;
        if (x < 10)
            return true;
        int y = x, result = 0;
        while (y > 0){
            result = result*10 + y % 10;
            y = y/10;
        }
        return result == x;

    }
}