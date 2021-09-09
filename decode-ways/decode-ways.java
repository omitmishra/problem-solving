class Solution {
    public int numDecodings(String str) {
        		
    if( str.charAt(0)==48 )
			return 0;
		if(str.length()==1)
			return 1;
        int [] counts=new int[str.length()+1];
           counts[0]=1;
           counts[1]=1; //if it is 12 
        for(int i=1;i<str.length();i++){
          int digit2 = Integer.parseInt(str.substring(i-1,i+1)); 
            if(digit2==0)
                return 0;
            if(digit2<=26&&digit2>=10 && (i==str.length()-1||str.charAt(i+1)!='0'))                                counts[i+1]+=counts[i-1];
            if(str.charAt(i)!='0') 
              counts[i+1]+=counts[i];    
            
        }
        
        return counts[str.length()];
		

    }
}