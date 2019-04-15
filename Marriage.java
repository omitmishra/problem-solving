import java.util.*;
 
 
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input
 
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        Scanner sc = new Scanner(System.in);
        
        // Write your code here
        int n=sc.nextInt();
        Map<Integer,List<Integer>> adjList=new HashMap<Integer,List<Integer>>();
        for(int i=1;i<=n;i++){
            adjList.put(i,new LinkedList<Integer>());
        }
        
        /*System.out.println(adjList);
        System.out.println(adjList.get(1));*/
        
        for(int i=1;i<n;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            adjList.get(s).add(d);
            adjList.get(d).add(s);
        }
        
        //System.out.println(adjList.get(1));
        
        /*for(int i=1;i<n;i++){
            System.out.println(adjList.get(i));
           
        }*/
        
        int noq=sc.nextInt();
        // int t=n+1;
        boolean q[]=new boolean[n+1];
        
        for(int i=1;i<=noq;i++){
            q[sc.nextInt()]=true;
        }
        
        
        LinkedList<Integer> queue=new LinkedList<Integer>();
        
        boolean visited[]=new boolean[n+1];
        
        visited[1]=true;
        queue.add(1);
        int count=0;
        int qc=0;
        while(!queue.isEmpty()){
            int s=queue.poll();
            //System.out.print(s+" ");
            Iterator<Integer> it=adjList.get(s).listIterator();
            while(it.hasNext()){
                int num=it.next();
                if(!visited[num]){
                    visited[num]=true;
                    queue.add(num);    
                }
            }
            
            Iterator<Integer> qt=queue.listIterator();
            boolean b=false;
            int r=Integer.MAX_VALUE;
            while(qt.hasNext()){
                int num=qt.next(); 
                //System.out.println(num);
                    // r=num;
                if(q[num]==true && num<r){
                    //System.out.println(num);
                    b=true;
                    r=num;    
                }
                
            }
            if(b==true){
                System.out.println(r);
                break;
            }
                
            
        }
        
        
    }
}