import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort implements Comparable<FrequencySort> {

	int count ;
	int value;
	public FrequencySort(int value, int count) {
		//	super();
		this.count = count;
		this.value = value;
	}	

	@Override
	public int compareTo(FrequencySort f) {
		if(this.count==f.count)
			return this.value-f.value;
		else
			return this.count-f.count;
	}
	public String toString()
	{
		return   count + " " + value + " ";
	}

}

class tes{
	void sorting(List<Integer> arr) {
		Map<Integer,FrequencySort> map=new HashMap<>();
		FrequencySort freq=null;
		for (int i = 0; i < arr.size(); i++) {
			freq=map.get(arr.get(i));
			if(freq==null)
				map.put(arr.get(i), new FrequencySort( arr.get(i),1));
			else 
				freq.count++;
		}
		Object [] value=map.values().toArray();
		Arrays.sort(value);
	//	Collections.sor
	//	Collections.s
		int arry []=new int[arr.size()];
		int k=0;
		for (int i = 0; i < value.length; i++) {
			freq =(FrequencySort) value[i];
			for (int j = 0; j < freq.count; j++) {
				arry[k]=freq.value;
				k++;
			}

		} 
		for (int x : arry) {
			System.out.println(x + " ");
		}

	}

	public static void main(String[] args)
	{
		int arr[] = { 3,1,2,2,4,2};
		List lst=new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			lst.add(arr[i]);

		}
		new tes().sorting(lst);



	}
}

