/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>map=new HashMap();
        getParent(root,map);
        Set<TreeNode> set=new HashSet();
         List<Integer> list =new ArrayList();
        level(root,set,k,map,list,target);
        
        return list;
    }
    
   void level(TreeNode root, Set<TreeNode> set,int k, Map<TreeNode,TreeNode>map,List<Integer> list,TreeNode target){
        Queue<TreeNode> q=new LinkedList();
        
        q.add(target);
            while(!q.isEmpty()){
                int size=q.size();
                
                for(int i=0;i<size;i++){
                    TreeNode parent=q.poll();
                    set.add(parent);
                    
                    if(k==0)
                      list.add(parent.val);  
                    
                    if(map.containsKey(parent) && !set.contains(map.get(parent))){
                        q.add(map.get(parent));
                    }
                    if(parent.left!=null && !set.contains(parent.left)){
                        q.add(parent.left);
                    }
                     if(parent.right!=null && !set.contains(parent.right)){
                        q.add(parent.right);
                    }
                   
                    
                }
                     k--;
                     if(k<0)
                        break;
                
            }
    }
    
    
    
    
    
   void  getParent(TreeNode root,  Map<TreeNode,TreeNode> map){
        if(root==null)
            return;
       
       if(root.left!=null){
           map.put(root.left,root);
           }
        if(root.right!=null){
           map.put(root.right,root);
           }
       getParent(root.left,map);
       getParent(root.right,map);
    }
}