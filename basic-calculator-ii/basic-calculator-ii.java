class Solution {
    public int calculate(String s) {
        char sign='+';
        int num=0;
         if (s == null || s.length() == 0)
            return 0;
      //  int i=0;
        Stack<Integer> st=new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char temp=s.charAt(i);
            
            if(Character.isDigit(temp))
                num=num*10+temp-'0';
             if(!Character.isDigit(temp) && temp != ' '|| i==s.length()-1){
            if(sign=='+')
                st.push(num);
            else if(sign=='-')
                st.push(-num);
             else if(sign=='*')
                st.push(st.pop()*num);
             else if(sign=='/')
                st.push(st.pop()/num);
                sign=temp;
                num=0;
            }
           //i++; 
        }
           int result = 0;
        for (int items: st)
            result += items;
        return result;

        
        //return result;
        
    }
}