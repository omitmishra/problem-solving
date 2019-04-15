
import java.util.Iterator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class NumOfEdges {
    public static LinkedList<Integer> adj[];
    public static boolean visited[];
    static int count, count1, max;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
 
 
        adj = new LinkedList[a + 1];
        for (int i = 0; i <= a; i++)
            adj[i] = new LinkedList();
        visited = new boolean[a + 1];
        while (b-- > 0) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            adj[c].add(d);
            adj[d].add(c);
        }
        for (int i = 0; i < a; i++) {
            count = 0;
            if (visited[i] == false) {
                dfs(i);
            }
            count1=Math.max(count1,count/2);
        }
        System.out.println(count1);
    }
    static void dfs(int g)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(g);
        visited[g] = true;
 
        while (q.size() != 0) {
            g = q.poll();
 
 
            Iterator<Integer> i = adj[g].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                count++;
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
 
 
                }
            }
        }
    }
 
 
}