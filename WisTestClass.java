
import java.util.*;

public class WisTestClass {
    static int count=0;
    static Stack<Node> s1, s2;
    static class Node {
        int data;
        Node left,right;
        boolean flag=false;
        Node(int data){
            this.data=data;
            left=right=null;
            this.flag=flag;
        }
    }
    public static void traverse(Node nodee,int count, int [] del){
         if(nodee==null)
                 return;
        else {
                 HashSet<Integer> set=new HashSet<Integer>();
                 for(int i=0;i<del.length;i++){
                     set.add(del[i]);
                 }
            traversee(nodee,set);
            }
    }
   static class Nodes {
        Node left,right;
        boolean flag=false;
        int data;
        Nodes(Node node,Boolean flag){
            this.right=node.right;
            this.left=node.left;
            this.data=node.data;
            this.flag=flag;
        }
    }

 public static void traversee(Node nodee,HashSet<Integer> set){
    boolean flag=false;
    // Nodes nodees= new Nodes(nodee,flag);
     Queue<Node> queue = new LinkedList<Node>();

     if(set.contains(nodee.data) && nodee.flag==false)
     {
         nodee.flag=true;
     }
     queue.add(nodee);

     while (!queue.isEmpty())
     {
         Node tempNode = queue.poll();
        
         if (tempNode.left != null) {
             if(set.contains(tempNode.left.data) && tempNode.flag==false) {
                 tempNode.left.flag = true;
                 count++;
             }
             else if(tempNode.flag==true){
                 tempNode.left.flag=true;
             }
             else {
            	 tempNode.left.flag=false;
             }
             queue.add(tempNode.left);
         }

         if (tempNode.right != null) {
             if(set.contains(tempNode.right.data) && tempNode.flag==false) {
                 tempNode.right.flag = true;
                 count++;
             }
             else if(tempNode.flag==true){
                 tempNode.right.flag=true;
             }
             else tempNode.right.flag=false;
             queue.add(tempNode.right);
         }
     }
    System.out.println(count);

 }
public static void main(String args[] ) throws Exception {
        Node root=null;
        Node node=null;
        Node mainroot=null;
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int t=sc.nextInt();
        int del[]=new int[t];
        for(int i=0;i<t;i++){
            del[i]=sc.nextInt();
        }
         count =0;
        for(int i=0;i<n;i++){
           if(root==null) {
                root=new Node(i+1);
              // root.data=i+1;
               //root.left=root.right=null;
               mainroot=root;
           }
            else {
                node=new Node(i+1);
               if(root.left==null){
                   root.left=node;
               }
               else root.right=node;

               if(i<n-1 && arr[i+1]!=root.data) {
                   if (root.left.data == arr[i + 1]) {
                       root = root.left;
                   } else root = root.right;
               }
           }
        }
            traverse(mainroot,count,del);

        }
}