


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class M {

	int vertex;
	Map<Integer,List<Integer>> adjmap;
	Queue<Integer> que= new LinkedList<>();



	public M(int size) {
		// TODO Auto-generated constructor stub
		vertex= size;

		adjmap=new HashMap<>();
		for (int i = 0; i < size; i++) {

			adjmap.put(i, new LinkedList<Integer>());
		}   
	}

	void AddEdge(int src,int dest) {
		//for (int i = 0; i < vertex; i++) {
		adjmap.get(src).add(dest);
		adjmap.get(dest).add(src);

		//	}


	}

	int  Bfs(int src){
		int count []=new int [vertex+1];
		boolean visited []=new boolean [vertex+1];
		que.add(src);
		boolean q[]=new boolean[vertex+1];
		q[3]=true;
		q[4]=true;
		q[5]=true;
		int min=Integer.MAX_VALUE;
		visited[src]=true;
		while(!que.isEmpty()) {
			int temp=que.poll();
			List<Integer> neighbor =adjmap.get(temp);
			for (int i = 0; i < neighbor.size(); i++) {
				if (!visited[neighbor.get(i)]) {
					visited[neighbor.get(i)]=true;
					que.add(neighbor.get(i));
					count[neighbor.get(i)]= count[temp]+1;
					if(q[neighbor.get(i)]==true)
						min=Math.min(min, neighbor.get(i));



				}



			}


		} 
		System.out.println(min);
		return min;

	}


	public static void main (String[] args)
	{
		M grap=new M(7);
		grap.AddEdge(1,2);
		grap.AddEdge(1,3);
		grap.AddEdge(1,4);
		grap.AddEdge(2,5);
		grap.AddEdge(2,6);
		grap.Bfs(1);

	}





}