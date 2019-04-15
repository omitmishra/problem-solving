import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Missingwords {
	public static void missingWords(int []a) {
		
		Map<Integer, Integer> map = new HashMap<> ();

		/* Logic to place the elements to Map */
		for(int i=0; i<a.length; i++){
			if(map.get(a[i]) == null){
				map.put(a[i], 1);
			}
			else{
				int frequency = map.get(a[i]);
				map.put(a[i], frequency+1);
			}
		}
		List lst =  new ArrayList(map.entrySet());
		 /* Sort the list elements based on frequency */
	       Collections.sort(lst, new Comparator() {
	            @Override	            
	            public int compare(Object obj1, Object obj2) {
	               return ((Comparable) ((Map.Entry) (obj1)).getValue())
	                  .compareTo(((Map.Entry) (obj2)).getValue());
	            }
	       });

	       int count=0;
	       
	       /* Place the elements in to the array based on frequency */
	       Iterator it = lst.iterator(); 
	    	   while(it.hasNext()) {
	            Map.Entry entry = (Map.Entry) it.next();
	            
	            int key = (int)entry.getKey();
	            int val = (int)entry.getValue();
	            
	            for(int i=0; i < val; i++){
	                a[count] = key;
	                count++;
	            }            
	       } 
	       
	       for(int i=0; i<a.length; i++){
	            System.out.println(a[i] +" ");
	        }
	    }
	
	public static void main( String args[]) {
		int a[] = {3,1,2,2,4};

		Missingwords.missingWords(a);
		// printSubArrays(arr, 0, 0);

	}


}

