import java.util.*;

class Flight
{
	int n;
	LinkedList<Integer>adjlist[];

	Flight(int n)
	{
		this.n=n;
		adjlist=new LinkedList[n];

		for(int i=0;i<n;i++)
		{
			adjlist[i]=new LinkedList<Integer>();
		}
	}

	void addEdge(int u,int v)
	{
		adjlist[u].add(v);
		adjlist[v].add(u);
	}

	void sortlist()
	{
		for(int i=0;i<n;i++)
		{
			Collections.sort(adjlist[i]);
		}
	}

	void BFS(int s,int d,int t,int c)
	{
		LinkedList<Integer>q=new LinkedList<>();
		q.add(s);
		int parent[]=new int[n];
		parent[s]=-1;
		int level[]=new int[n];
		boolean visited[]=new boolean[n];
		visited[s]=true;
		level[s]=0;
		int time=0;
		while(!q.isEmpty())
		{

			s=q.poll();
			if(s==d)
			{

				break;
			}
			else
			{

				Iterator<Integer>i=adjlist[s].listIterator();

				while(i.hasNext())
				{
					int x=i.next();

					if(visited[x]!=true)
					{
						q.add(x);
						level[x]=level[s]+1;
						parent[x]=s;
						visited[x]=true;
					}

				}

			}



		}

		int i=d;

		String r=(i+1) +" ";

		while(parent[i]!=-1)
		{
			r= (parent[i] + 1) + " " + r;
			i=parent[i];
		}


		System.out.println(level[d]+1);
		System.out.println(r);

	}
	public static void main(String[] args) {

		Scanner o=new Scanner(System.in);

		int n=o.nextInt();

		Flight f=new Flight(n);

		int m=o.nextInt();

		int t=o.nextInt();
		int c=o.nextInt();

		for(int i=0;i<m;i++)
		{
			f.addEdge(o.nextInt()-1,o.nextInt()-1);
		}

		f.sortlist();

		int x=o.nextInt();
		int y=o.nextInt();

		f.BFS(x-1,y-1,t,c);






	}
}