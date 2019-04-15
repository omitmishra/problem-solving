
import java.util.*;
public class FriendRelation {
	static HashMap<String,Integer> map=new HashMap<>();
	static int v;
	static LinkedList<Integer> adj[];
	FriendRelation(int v){
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList();

		}
	}

	static void addedge(int u,int v) {
		adj[u].add(v);
		adj[v].add(u);
	}


	static	String connected[] =new String[5];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=5;
		FriendRelation relation= new FriendRelation(v);
		//String connected[] =new String[v];
		int u,V;
		for(int i=0;i<4;i++) {
			String str1=sc.next();
			String str2=sc.next();
			if(map.isEmpty()) {
				map.put(str1, 0);
				map.put(str2,1);
				u=0;V=1;
				connected[0]=str1;
				connected[1]=str2;
				addedge(u,V);
			}
			else {
				if(map.containsKey(str1))
					u=map.get(str1);
				else {
					u=map.size();
					map.put(str1, u) ;
					connected[u]=str1;
				}
				if(map.containsKey(str2))
					V=map.get(str2);
				else {
					V=map.size();
					// System.out.println(V);
					map.put(str2, V);
					connected[V]=str2;
				}
				addedge(u,V); 
			}

			// BFS("Ram");
		}

		for(Map.Entry<String, Integer> out:map.entrySet()) {
			System.out.println(out.getKey()+":"+out.getValue());
		}
		printgh(relation);



	}
	static void printgh(FriendRelation grph) {
		for(int j = 0; j < grph.v; j++) 
		{ 
			System.out.println("Adjacency list of vertex "+ v); 
			System.out.print("head"); 
			for(Integer pCrawl: grph.adj[j]){ 
				System.out.print(" -> "+connected[pCrawl]  ); 
			} 
			System.out.println("\n"); 
		} 

	}

}