class Solution {
         List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     Arrays.sort(candidates);
        
        gr(candidates,0,target,new ArrayList<Integer>());
        return res;
    }
    
    void gr(int [] a,int st,int t, ArrayList<Integer> temp){
        if(t<=0){
        if(t==0){
            res.add(new ArrayList<Integer> (temp));
        }
          return ;
            
        }
            for(int i=st;i<a.length;i++){
                  if (i==st || a[i]!=a[i-1]){
                int te=a[i];
                temp.add(te);
                gr(a,i,t-te,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}