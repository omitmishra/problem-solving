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
        int n=A.length();
        int ans=0;
        StringBuilder sb=new StringBuilder();
        for(char c:A.toCharArray()){
            if(sb.indexOf(String.valueOf(c))==-1){
                sb.append(c);
                ans=Math.max(ans,sb.length());
            }else{
                int k=sb.indexOf(String.valueOf(c));
                sb.delete(0,k+1);
                 sb.append(c);
            }
        
        }
        
        return ans;
        
    }
}