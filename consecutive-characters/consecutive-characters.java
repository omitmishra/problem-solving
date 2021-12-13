class Solution {
    public int maxPower(String s) {
        int max = 0;
	int l = 0, r = 0;
	while (r < s.length()) {
		while (r < s.length() && s.charAt(r) == s.charAt(l)) r++;
		max = Math.max(max, r - l);
		l = r;
	}
	return max;
    }
}