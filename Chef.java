import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Chef {

	public static boolean hasCycle(String arr[]) 
	{
		String[] myStringArray;
		myStringArray = new String[]{"FAT", "FIBER", "CARB"};
		List<String> list = Arrays.asList(myStringArray);
		List<String> list1 = Arrays.asList(arr);
		for(int i=0;i<arr.length;i++) {
			String temp=list.get(i);
			if (temp.startsWith("FAT")||temp.startsWith("FIBER")||temp.startsWith("CARB")) {

			}


		}


		return false;
	}




	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		Chef chef=new Chef();
		String[] myStringArray;
		myStringArray = new String[]{"FATOIL", "FIBERSPINACH", "CARBRICE","FATCHEEZ"};
		chef.hasCycle(myStringArray);

	}}