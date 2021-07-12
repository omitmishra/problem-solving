class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
       HashSet<String> set = new HashSet<>();
		HashSet<String> ans = new HashSet<>();
        int n = s.length();
        for(int i=0;i<=n-10;i++){
            String sub = s.substring(i,i+10);
           if(set.contains(sub)){
                ans.add(sub);
            }else{
                set.add(sub);
            }
        }
        
        return new ArrayList<>(ans);
  
    }
}