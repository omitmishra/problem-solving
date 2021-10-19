class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     
            int l1=nums1.length,l2=nums2.length,j=0;
        int[] op=new int[l1];
        Arrays.fill(op, -1);

  	    HashMap<Integer, Integer> hm = new HashMap<>();
        
		for (int i=0;i<l2;i++) {
			hm.put(nums2[i], i+1);
		}
        for(int i=0;i<l1;i++){
            for(j=hm.get(nums1[i]);j<l2;j++){
                if(nums2[j]>nums1[i]){
                    op[i]=nums2[j];
                    break;
                }
            }
        }
        
        return op;
    }
}