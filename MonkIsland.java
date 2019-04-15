

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MonkIsland {
	
	static int v;
	static LinkedList<Integer> adj[];
		MonkIsland(int v){
			this.v=v;
			adj=new LinkedList [v+1];
			for(int i=1;i<=v;i++) {
				adj[i]=new LinkedList();
			}
		}
		
	static void addedge(int u,int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++) {
		int N=sc.nextInt();
		int M=sc.nextInt();
		MonkIsland mon=new MonkIsland(N);
		for(int j=0;j<M;j++) {
			int u=sc.nextInt();
			int v=sc.nextInt();
			addedge(u,v);
		}
		BFS(1,N);
		
		
		}
		
	}
	
	static void BFS(int s,int N) {
		boolean visited[]=new boolean[v+1];
		LinkedList<Integer> que=new LinkedList<>();
		int path[]=new int[v+1];
		for(int k=0;k<=v;k++) {
			path[k]=-1;
		}
		visited[s]=true;
		//int x=s;
		que.add(s);
		while(!que.isEmpty()) {
			 s=que.poll();
			
			Iterator<Integer> itr=adj[s].iterator();
			while(itr.hasNext()) {
				int n=itr.next();
				if(!visited[n]) {
					que.add(n);
					visited[n]=true;
					path[n]=s;
				}
			}
		}
		int count=0;
		int currVertex=N;
		while(path[currVertex]!=-1) {
			count++;
			currVertex=path[currVertex];
		}
		System.out.println(count);
	}

}