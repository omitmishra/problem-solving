import java.util.ArrayList;
import java.util.List;

public class sentences {

	static void Sucld(List lst) {
		for (int i = 0; i < lst.size(); i++) {
			String first=(String) lst.get(i);
			String temp []=first.split(" ");
			for(String t: temp) {
				
			}
			System.out.println(first);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> se = new ArrayList<>();
		se.add("ravi is goker");
		 sentences.Sucld(se);


	}

}
