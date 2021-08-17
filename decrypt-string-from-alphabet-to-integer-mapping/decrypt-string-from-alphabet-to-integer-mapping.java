class Solution {
    public String freqAlphabets(String s) {
          char c = 'j';
        for (int k = 10; k <= 26; k++) {
            s = s.replaceAll(String.valueOf(k) + "#", String.valueOf(c));    
            c++; 
        }
        c = 'a';
        for (int k = 1; k <= 9; k++) {
            s = s.replaceAll(String.valueOf(k), String.valueOf(c));    
            c++;
        }
   
        return s;
    }
}