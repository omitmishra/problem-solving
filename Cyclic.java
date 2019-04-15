

import java.io.*;

import java.util.*;

class Cyclic
{
	public int V;
	public static LinkedList<Integer> adj[];

	Cyclic(int v){
		V=v;
		adj=new LinkedList[V];
		for(int j=0;j<V;j++){
			adj[j]=new LinkedList<Integer>();
		}

	}

	public void addEdge(int a, int b){
		adj[a].add(b);
	}


	public static boolean hasCycle(int s,LinkedList<Integer>[] alist,boolean[] visited,int [] count) 
	{
		//int s=0;

		LinkedList<Integer> queue=new LinkedList();

		queue.add(s);
		visited[s]=true;

		while(queue.size() != 0){
			s=queue.poll();
			Iterator<Integer> z = adj[s].listIterator();
			while(z.hasNext()){
				int k=z.next();
				if(!visited[k]){
					queue.add(k);
					visited[k]=true;
					count[k]=s;
				}
				else if (count[s] == k) 
					return true; 

			}
		}


		return false;
	}




	public static void main(String args[]){
		Scanner s=new Scanner(System.in);

		int T,i,j,n,m,a,b;
		//Graph graph;
		T=s.nextInt();

		for(i=0;i<T;i++){

			n=s.nextInt();
			m=s.nextInt(); 
			Cyclic graph=new Cyclic(n+1);            
			for(j=0;j<m;j++){


				a=s.nextInt();
				b=s.nextInt();
				graph.addEdge(a,b);

			}


			boolean visited[]=new boolean[n+1];
			int count[]=new int[n+1];
			boolean flag=false;
			// boolean explored[]=new boolean[n];  
			int k=1;
			while(k<=n) {
				if(graph.hasCycle(k,adj,visited,count)){
					//k++;
					flag=true;
				}
				k++;
			}
			if(flag){
				System.out.println("1");
			}
			else{
				System.out.println("0");

			}
		}
	}
}