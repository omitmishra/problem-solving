


import java.util.*;
import java.io.*;

public class Minswap {
	Node root;

	static class Node {
		int data;
		Node left, right;
		Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public Node insertLevelOrder(int[] arr, Node root,int i)
	{
		if (i < arr.length) {
			Node temp = new Node(arr[i]);
			root = temp;
			root.left = insertLevelOrder(arr, root.left,2 * i + 1);
			root.right = insertLevelOrder(arr, root.right,2 * i + 2);
		}
		return root;
	}

	public ArrayList<Integer> inOrder(Node root, ArrayList<Integer> arrli)
	{
		if (root != null) {
			inOrder(root.left, arrli);
			// System.out.print(root.data + " ");
			arrli.add(root.data);
			inOrder(root.right, arrli);
		}
		return arrli;
	}

	public static int findMinSwapsToSort(int[] ar) {
		int n = ar.length;
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			m.put(ar[i], i);
		}
		Arrays.sort(ar);
		for (int i = 0; i < n; i++) {
			ar[i] = m.get(ar[i]);
		}
		m = null;
		int swaps = 0;
		for (int i = 0; i < n; i++) {
			int val = ar[i];
			if (val < 0) continue;
			while (val != i) {
				int new_val = ar[val];
				ar[val] = -1;
				val = new_val;
				swaps++;
			}
			ar[i] = -1;
		}
		return swaps;
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> arrli = new ArrayList<Integer>();
		Minswap t2 = new Minswap();
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}


		t2.root = t2.insertLevelOrder(arr, t2.root, 0);
		t2.inOrder(t2.root, arrli);
		int a1[] = new int[n];
		for(int i = 0; i < arrli.size(); i++) {   
			a1[i] = arrli.get(i);
		} 
		System.out.println(findMinSwapsToSort(a1));
	}
}


