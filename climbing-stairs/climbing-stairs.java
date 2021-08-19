class Solution {
        static HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();

    public int climbStairs(int n) {
        if(map.containsKey(n))
            return map.get(n);
        if(n==0)return 1;
         if(n==2)return 2;
        if(n==1)return 1;
        if(n==3)return 3;
      map.put(n,climbStairs(n-1)+climbStairs(n-2));

        
        return map.get(n);
    }
}