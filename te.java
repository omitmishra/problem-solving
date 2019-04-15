import java.io.*;
import java.util.*;


public class te {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int Q = Integer.parseInt(arr[1]);
		String[] arr_Arr = br.readLine().split(" ");
		int[] Arr = new int[N];
		for(int i_Arr=0; i_Arr<arr_Arr.length; i_Arr++)
		{
			Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
		}

		int[] L = new int[Q];
		int[] R = new int[Q];
		int[] Val = new int[Q];
		for(int i_L=0; i_L<Q; i_L++)
		{
			String[] temp = br.readLine().split(" ");
			L[i_L] = Integer.parseInt(temp[0]);
			R[i_L] = Integer.parseInt(temp[1]);
			Val[i_L] = Integer.parseInt(temp[2]);

		}

		int[] out_ = AND_Queries(Arr, Val, L, N, Q, R);
		System.out.print(out_[0]);
		for(int i_out_=1; i_out_<out_.length; i_out_++)
		{
			System.out.print(" " + out_[i_out_]);
		}

		wr.close();
		br.close();
	}
	static int[] AND_Queries(int[] Arr, int[] Val, int[] L, int N, int Q, int[] R){
		int p=0;
		while(p<Q) {
			for (int i = L[p]; i <=R[p]; i++) {
				Arr[i - 1] = Arr[i - 1] & Val[p];
			}p++;
		}

		return Arr;
		// Write your code here
	}

	public static int playlist(List<String> songs, int k, String q) {
		// Write your code here
		int max=0;
		int min=0;
		int res=0;
		int i=songs.size();
		if (q.equalsIgnoreCase(songs.get(k)))
			return 0;
		while(k<i) {
			if(q.equalsIgnoreCase(songs.get(k))){
				return max;
			}
			else {
				k++;
				max++;
			}
		}
		while(k>=0) {
			if(q.equalsIgnoreCase(songs.get(k))){
				return min;
			}
			else {
				k--;
				min++;
			}
		}

		res=Math.min(min, max);
		return res;
	}
	void meem() {
		Object obj = new JSONParser().parse(new FileReader("JSONExample.json")); 
        
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
          
        // getting firstName and lastName 
        String firstName = (String) jo.get("firstName"); 
        String lastName = (String) jo.get("lastName"); 
          
        System.out.println(firstName); 
        System.out.println(lastName); 
          
        // getting age 
        long age = (long) jo.get("age"); 
        System.out.println(age); 
          
        // getting address 
        Map address = ((Map)jo.get("address")); 
          
        // iterating address Map 
        Iterator<Map.Entry> itr1 = address.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
            System.out.println(pair.getKey() + " : " + pair.getValue()); 
        } 
          
        // getting phoneNumbers 
        JSONArray ja = (JSONArray) jo.get("phoneNumbers"); 
          
        // iterating phoneNumbers 
        Iterator itr2 = ja.iterator(); 
          
        while (itr2.hasNext())  
        { 
            itr1 = ((Map) itr2.next()).entrySet().iterator(); 
            while (itr1.hasNext()) { 
                Map.Entry pair = itr1.next(); 
                System.out.println(pair.getKey() + " : " + pair.getValue()); 
            } 
        } 
    } 
} 
	}
	
}