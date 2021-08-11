class Solution {
    public List<List<String>> partition(String s) {
        
         List<List<String>> list =new ArrayList<>();
         dfs(list,s,new ArrayList<>());
        
        return list;
        
    }
    void dfs( List<List<String>> li,String str,List<String> list){
        if(str.length()==0){
            li.add(new ArrayList<>(list));
        }
        for(int i=1;i<=str.length();i++){
            String temp=str.substring(0,i);
            if(isPalindrome(temp,temp.length())){
             list.add(temp);
              dfs( li, str.substring(i), list);
                list.remove(list.size()-1);
            }
            
        }
    }
     public boolean isPalindrome(String s, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }
        return true;
    }
}