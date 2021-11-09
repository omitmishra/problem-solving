class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
          Map<Character,ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0;i<26;i++)
            map.put((char)('a'+i),new ArrayList<>());
        
        for(String word : words)
        {
            int wmask=0;
            Set<Character> set = new HashSet<>();
            for(char ch: word.toCharArray())
                wmask = wmask | (1 << (ch-'a'));
            
            for(char ch: word.toCharArray())
            {
                if(set.contains(ch))
                    continue;
                set.add(ch);
                map.get(ch).add(wmask);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(String puzzle : puzzles)
        {
            int pmask=0;
            for(char ch: puzzle.toCharArray())
                pmask = pmask | (1 << (ch-'a'));
            
            char fch = puzzle.charAt(0);
            int count = 0;
            for(int wmask : map.get(fch))
            {
                if((wmask & pmask) == wmask)
                    count++;
            }
            ans.add(count);
        }
        
        return ans;

    }
}