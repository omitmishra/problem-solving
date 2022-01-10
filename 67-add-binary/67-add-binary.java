class Solution {
    public String addBinary(String a, String b) {
        //toCharArray
        char ch []=a.toCharArray();
        char ch1 [] =b.toCharArray();
       int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder sb=new StringBuilder();
        while(i>=0 || j>=0){
            int sum=carry;
            if(i>=0){
                sum=sum+ch[i]-'0';
            }
            if(j>=0){
               sum=sum+ch1[j]-'0';
            }
            sb.append(sum%2);
            carry=sum/2;
            i--;
            j--;
            
        }
        if(carry>0){
            sb.append(carry);
        }
        
        
        return sb.reverse().toString();
        
    }
}