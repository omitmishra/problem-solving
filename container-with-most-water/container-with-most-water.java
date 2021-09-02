class Solution {
    public int maxArea(int[] height) {
         int result = 0;
        
        int left = 0;
        int right = height.length - 1;
        
        while(left < right) {
            int leftSideHeight = height[left];
            int rightSideHeight = height[right];
            int h = Math.min(leftSideHeight, rightSideHeight);
            int w = right - left;
            result = Math.max(result, h * w);
            if(leftSideHeight > rightSideHeight) {
                right--;
            } else {
                left++;
            }
        }
        
        return result;
    }
}