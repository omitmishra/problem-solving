class Solution {
    public int hammingDistance(int x, int y) {
        int lastBitX, lastBitY, count = 0;
        
        for(int i = 0; i < 32; i++){
            lastBitX = x & 1;
            lastBitY = y & 1;
            
            if((lastBitX ^ lastBitY) == 1){
                count++;
            }
            
            x >>= 1;
            y >>= 1;
        }
        
        return count;
    }
}