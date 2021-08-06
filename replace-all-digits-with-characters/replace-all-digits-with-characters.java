class Solution {
    public String replaceDigits(String s) {
           char[] ch = s.toCharArray();
        for(int i=1;i<ch.length;i+=2){
            if(Character.isDigit(ch[i]))
                //adding the numeric value to previous character, 'a'+1=b
                ch[i] = (char) (ch[i-1]+Character.getNumericValue(ch[i]));
        }
        return new String(ch);
    }
}