class Solution {
        public int maxLength(List<String> arr) {
        return maxLength(arr, 0, "");
    }
    
    private int maxLength(List<String> arr, int index,String curr){
        if(index == arr.size()){
            return curr.length();
        }
        
        int include = 0, exclude = 0;
        
        if(canMerge(curr + arr.get(index))){
            include = maxLength(arr, index + 1, curr + arr.get(index));
        }
        
        exclude = maxLength(arr, index + 1, curr);
        
        return Math.max(include, exclude);
    }
    
    private boolean canMerge(String s){
        int[] chars = new int[26];
        
        for(char ch : s.toCharArray()){
            if(chars[ch - 'a'] > 0){
                return false;
            }
            
            chars[ch - 'a']++;
        }
        
        return true;

    }
}