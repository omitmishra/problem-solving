class Solution {
    public boolean rotateString(String A, String B) {
          if(A.length()==0 && B.length()==0){
            return true;
        }
        StringBuilder d=new StringBuilder(A);
        for(int i=0;i<A.length();i++){
            d.append(d.charAt(0));
            d.deleteCharAt(0);
            if(d.toString().equals(B)){
                return true;
            }
        }
        return false;
    }
}