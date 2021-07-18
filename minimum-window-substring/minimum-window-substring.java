class Solution {
    public String minWindow(String s, String t) {
       if(s.length() == 0) return "";
        
        int[] tCounts = new int[256]; // 256 coz, involves both lower and upper cases
        for(int i=0;i<t.length();i++){
            tCounts[t.charAt(i)]++;
        }
        
        int min = Integer.MAX_VALUE;
        String minWindowStr = "";
        
        int left = 0;
        int lettersToFind = t.length(); 
        
        for(int right=0; right<s.length();right++){
            
            int rightChar = s.charAt(right);
            if(tCounts[rightChar] > 0){ // checks if the letter exists in t
                lettersToFind--;
            }
            tCounts[rightChar]--; //decrement the count of currrent letter. Goes to negative if not in t.
            
            while(lettersToFind == 0){ //all letters found
                if (right-left < min){
                    min = right - left;
                    minWindowStr = s.substring(left, right+1); // record min len String
                }
                
                int leftChar = s.charAt(left); 
                if(tCounts[leftChar] >= 0){ //The char at left is -ve, if the letter is not in t. 
                    lettersToFind++;  
                }
                tCounts[leftChar]++; // put the char at left back in counts
                left++; 
            }
        }
        return minWindowStr;
    }
}