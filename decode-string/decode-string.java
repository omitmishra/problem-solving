class Solution {
    public String decodeString(String s) {
        Stack<String>st=new Stack();
        int i=0;
        int n=s.length();
        int num=0;
       // StringBuilder sb=null;
        String curr="";
        while(i<n){
            char c=s.charAt(i);
            
            if(Character.isDigit(c)){
                  num = num*10 + c - '0';
            }
            else if(c=='['){
                 st.push(curr);
                 st.push(String.valueOf(num));
                 num =0;
                 curr = "";
                
            }else if(c==']'){
                 int times = Integer.parseInt(st.pop());
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<times; j++){
                    sb.append(curr);
                }
                curr = st.pop() + sb.toString();
                
            }else{
                curr=curr+c;
            }
            i++;
            
        }
        
       return curr; 
    } 
    
}