import java.util.HashSet;
import java.util.Scanner;

public class MinSubArr {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = 6;//sc.nextInt();
		int k = 3;//sc.nextInt();
		int a[] = new int[] {1,2,3,2,3,2};

		for (int i = 0; i < n; i++) {
			// a[i] = sc.nextInt();
		}
		int out=minsub(a,n,k);
		System.out.print(out);

	}
	public static int minsub(int a[],int n,int k){
		HashSet<Integer> set=new HashSet<>();
		int count=0;
		int l=0;
		boolean flag=false;
		HashSet<Integer> set_lookup=new HashSet<>();
		// Queue<Integer> window= new LinkedList<>();
		for(int i=0;i<=n-k;i++){ 
			set.clear();
			for(int j=i;j<k+i;j++)
			{
				//window.add(a[j]);
				set.add(a[j]);
			}
			if(set.size()==k) {
				//set.
				flag=true;
				break;
			}
		}
		if(flag)
			l=k;

		return l;

	}

}