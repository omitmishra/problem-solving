import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
 
public class Arya {
 
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
 
    static boolean[] visited = null;
    static List<Integer> arrayOfList[] = null;
 
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Reader reader = new Reader();
 
        int vertices = reader.nextInt();
        int edges = reader.nextInt();
 
        arrayOfList = new LinkedList[vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            arrayOfList[i] = new LinkedList<>();
        }
 
        int[] armies = new int[vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            armies[i] = reader.nextInt();
        }
        // System.out.println(Arrays.toString(armies));
        //  add edges
        for (int i = 1; i <= edges; i++) {
            int source = reader.nextInt();
            int destination = reader.nextInt();
            arrayOfList[source].add(destination);
            arrayOfList[destination].add(source);
        }
 
 
        //  print edges
        /*
        for (int i = 1; i <= vertices; i++) {
            for (Integer eachListElement : arrayOfList[i]) {
                System.out.print(" -> " + (eachListElement));
            }
            System.out.println("");
        }
        */
        int soldierKilled = 0;
        int soldierInj = 0;
        TreeSet<Integer> startTent = new TreeSet<>();
 
        visited = new boolean[vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                TreeSet<Integer> connectedTents = new TreeSet<>();
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int current = stack.pop();
                    if (!visited[current]) {
                    	
                        visited[current] = true;
                        connectedTents.add(current);
                        // get all the neighbors
                        for (Integer neighbor : arrayOfList[current]) {
                            if (!visited[neighbor])
                                stack.push(neighbor);
                        }
                    }
                }
 
                int max = Integer.MIN_VALUE;
                int start = 0;
                int tempCount = 0;
                for (Integer eachTent : connectedTents) {
                    // System.out.println(eachTent + "  __ ");
                    tempCount += armies[eachTent];
                    if (max < armies[eachTent]) {
                        max = armies[eachTent];
                        start = eachTent;
                    }
                }
                startTent.add(start);
                soldierKilled += max;
                soldierInj += (tempCount - max);
            }
        }
        out.println(soldierKilled + " " + soldierInj);
        for (Integer eachTent : startTent) {
            out.print(eachTent + " ");
        }
        out.println();
        out.flush();
    }
}