import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Permutation
{
	public static void main(String[] args) {

		Scanner o=new Scanner(System.in);
		int n=o.nextInt();
		HashMap<String,Integer>h=new HashMap<>();
		ArrayList<String>a=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			int x=o.nextInt();
			a.add(Integer.toString(x));
		}

		String start="";
		for(int i=0;i<n;i++)
		{
			start+=a.get(i);
		}

		String end="";

		for(int i=1;i<=n;i++)
		{
			end+=Integer.toString(i);
		}

		//System.out.println(start);
		//System.out.println(end);

		Queue<String>q=new LinkedList<>();
		q.add(start);

		h.put(start,0);

		while(!q.isEmpty())
		{
			String curr=q.poll();
			int c=h.get(curr);
			//System.out.println(curr);
			//System.out.println(h);
			if(curr.equals(end))
			{
				System.out.println(c);
				break;
			}

			for(int i=1;i<n;i++)
			{
				String k="";
				for(int j=i;j>=0;j--)
				{
					k+=curr.charAt(j);
				}

				for(int j=i+1;j<n;j++)
				{
					k+=curr.charAt(j);
				}

				if(!h.containsKey(k))
				{	q.add(k);
				h.put(k,c+1);
				}
			}
		}

	}
}
