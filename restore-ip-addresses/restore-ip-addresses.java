class Solution {
    public List<String> restoreIpAddresses(String s) {
      List<String> list=new ArrayList<>();
      dfs(s,0,new ArrayList<String>(),list);
      return list;
    
}
public void dfs(String s,int step,ArrayList<String> ls,List<String> list) {
    if(step==3) {
        String s1=ls.get(0);
        String s2=ls.get(1);
        String s3=ls.get(2);
        String s4=s;            
        if(isvalid(s1)&&isvalid(s2)&&isvalid(s3)&&isvalid(s4))
        {
            list.add(s1+'.'+s2+'.'+s3+'.'+s4);
        }
        return;
    }
    for(int i=1;i<4 && i<=s.length();i++) {
        
        String ss=s.substring(0,i);
        ls.add(ss);
        dfs(s.substring(i),step+1,ls,list);
        ls.remove(ls.size()-1);
    }
}
public boolean isvalid(String s) {
    
    if(s.length()>3||s.length()<1)
        return false;
    if(s.length()>1&&s.charAt(0)=='0') 
        return false;
    if(Integer.parseInt(s)>255)
        return false;
    
    return true;
   }
}