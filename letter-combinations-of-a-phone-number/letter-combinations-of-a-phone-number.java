class Solution {
  Map<String,String> map=new HashMap<>(){{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
    }};
     
    
    List<String> list =new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
        get(digits,"");
        
        return list;
    }
    
   void  get(String str,String ans){
       if(str.length()==0){
           list.add(ans);   
           return ;
       }
         String temp=str.substring(0,1);
         String temp1= map.get(temp);
       for(int i=0;i<temp1.length();i++){
           //char ch=temp1.charAt(st);
            String letter =temp1.substring(i, i + 1);
           
           get(str.substring(1),ans+letter);
       
         }
   }
}