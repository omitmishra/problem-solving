class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
      if(croakOfFrogs.length() == 0) return 0;

	int min = 0;
	int[] cnt = new int[5];     // c r o a k

	int done = 0;
	for(char c: croakOfFrogs.toCharArray()){
		if(c == 'c'){
			cnt[0]++;
			min = Math.max(min, cnt[0] - done);
		}else if(c == 'r'){
			cnt[1]++;
			if(cnt[1] > cnt[0]) return -1;
		}else if(c == 'o'){
			cnt[2]++;
			if(cnt[2] > cnt[1]) return -1;
		}else if(c == 'a'){
			cnt[3]++;
			if(cnt[3] > cnt[2]) return -1;
		}else if(c == 'k'){
			cnt[4]++;
			if(cnt[4] > cnt[3]) return -1;
		}

		done = Integer.MAX_VALUE;
		for(int val: cnt){
			done = Math.min(done, val);
		}
	}

	if(done * 5 != croakOfFrogs.length()){
		return -1;
	}

	return min;  
    }
}