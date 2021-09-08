class Solution {
    public int uniqueLetterString(String S) {
          Map<Character, ArrayList<Integer>> h = new HashMap<>();
        char[] ca= S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            ArrayList<Integer> l = h.getOrDefault(ca[i], new ArrayList<>());
            l.add(i);
            h.put(ca[i], l);
        }
        int sum  = 0;
        for (Map.Entry<Character, ArrayList<Integer>> entry : h.entrySet()) {
            ArrayList<Integer> l = entry.getValue();
            for (int i = 0; i < l.size(); i++) {
             int left = i == 0 ? l.get(i) : l.get(i) - l.get(i - 1) - 1;
             int right = i == l.size() - 1 ? S.length() - l.get(i) - 1 : l.get(i + 1) - l.get(i) - 1;
                sum = (sum + 1 + left + right + left * right) % 1000000007;
            }
        }
        return sum;

    }
}