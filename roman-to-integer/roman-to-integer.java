class Solution {
    public int romanToInt(String s) {
          Map<Character,Integer> map = new HashMap<>();
    map.put('I', 1); 
    map.put('V', 5); 
    map.put('X', 10); 
    map.put('L', 50);
    map.put('C', 100); 
    map.put('D', 500);
    map.put('M', 1000); 
        char prev='0';
        int sum=0;
        
        for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
            if(i!=0 && map.get(prev)<map.get(c)){
            sum=sum-map.get(prev);
            sum=sum-map.get(prev);
            sum=sum+map.get(c);
            prev=c;
            }else{
                sum =sum+map.get(c);
                prev=c;
            }
        }
        return sum;
        }
}