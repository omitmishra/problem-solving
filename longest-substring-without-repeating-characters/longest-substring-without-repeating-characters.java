class Solution {
    
//     String getUniqueCharacterSubstring(String input) {
//     Map<Character, Integer> visited = new HashMap<>();
//     String output = "";
//     for (int start = 0, end = 0; end < input.length(); end++) {
//         char currChar = input.charAt(end);
//         if (visited.containsKey(currChar)) {
//             start = Math.max(visited.get(currChar)+1, start);
//         }
//         if (output.length() < end - start + 1) {
//             output = input.substring(start, end + 1);
//         }
//         visited.put(currChar, end);
//     }
//     return output;
// }
    public int lengthOfLongestSubstring(String A) {
         int en=0;
        int n=A.length();
        int  le=0;
        Set set=new HashSet();
        int st=0;
        while(st<n){
            if(!set.contains(A.charAt(st))){
                set.add(A.charAt(st));
                st++;
                le = Math.max(le,set.size());
        }else{
            set.remove(A.charAt(en));
            en++;
        }
            
        }
        return le;
    }
        
    }
