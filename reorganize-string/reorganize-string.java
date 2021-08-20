class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer>map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
          PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        
        StringBuilder sb=new StringBuilder();
        while(maxHeap.size()>1){
             char current = maxHeap.remove(); // maximum frequent
             char next = maxHeap.remove(); 
             sb.append(current);
             sb.append(next); // alternatively adding
             map.put(current, map.get(current) - 1);
             map.put(next, map.get(next) - 1);
            if (map.get(current) > 0)
                maxHeap.add(current);
            if (map.get(next) > 0)
                maxHeap.add(next);
            
        }
         if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (map.get(last) > 1)
                return "";
            sb.append(last);
        }
        return sb.toString();
    }
    
}