

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class permutation{



	public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
		List lst=new ArrayList<>();
		long ans=0;
		for (int i = 0; i < sentences.size(); i++) {
			String first=sentences.get(i);
			String temp []=first.split(" ");
			for(String t: temp) {
				permute(t, 0, first.length()-1,wordSet,lst);
				//long =lst.size();
			}

		}
		// Write your code here
		return lst;
	}
	static void permute(String str, int l, int r, List<String>wordSet,List<String>lst) 
	{ 
		if (l == r) { 
			System.out.println(str); 
			if(wordSet.contains(str)) {
				lst.add(str);
			}

		}
		else
		{ 
			for (int i = l; i <= r; i++) 
			{ 
				str = swap(str,l,i); 
				permute(str, l+1, r,wordSet,lst); 
				str = swap(str,l,i); 
			} 
		} 
	} 

	static String swap(String a, int i, int j) 
	{ 
		char temp; 
		char[] charArray = a.toCharArray(); 
		temp = charArray[i] ; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		// String str=String.valueOf(charArray);
		return String.valueOf(charArray); 
	} 


	int Subarraygeneration(int arr[] ,int start,int end) {
		if(arr.length==0)
			return 0;

		if (end==arr.length)
			return 0;
		else if (start > end) 
			return Subarraygeneration(arr ,0,end+1);
		else {
			for (int i = start; i <end+1; i++) {


				System.out.println(arr[i]);

			}
			System.out.println("\n");


			// set.add(maxSubArraySum(arr, start, end));
			return Subarraygeneration(arr, start + 1, end);
		}



	}

	static void LongestnonrepeatingSubstring(String  str)	{
		if(str.length()==0)
			return;
		List<Character> lst=new ArrayList<>();
		int prevsize=0;
		for (int i = 0; i < str.length(); i++) {
			if(!lst.contains(str.charAt(i))) {
				System.out.println(str.charAt(i));
				lst.add(str.charAt(i));
			}
			else {
				lst.clear();
				lst.add(str.charAt(i));
			}
			//prevsize++;
			if(lst.size()>prevsize)
				prevsize=lst.size();
		}
		System.out.println(prevsize);
	}

	static void dutchProblem(int arr[]) {
		if(arr.length==0)
			return ;
		int start=0;
		int mid = arr.length/2;
		int end=arr.length-1;
		int temp[]=new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==1) {
				temp[mid]=1;
				mid++;
			}	

			if(arr[i]==0) {
				temp[start]=0;
				start++;
			}
			else if (arr[i]==2) {
				temp[end]=2;
				end--;
			}
		}
		System.out.println(temp);
	}
	static void minimumsubarraydistinct(int arr[]) {
		int k=3;
		int temp=0,d=0;
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			//List temp=new ArrayList<>();

			if (d==k)
				break;

			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
				d++;
			}
			else {
				if(temp<d)
					temp=d;
				d=0;
				map.clear();
				map.put(arr[i], 1); 
				d++;
			}
		}
		System.out.println(d);
	}
	static String canMakeAPalindrome(String testStr) {
		int[] frequencyArr = createFrequencyArray(testStr);
		String str="YES";
		int oddCharCount = 0;

		for (int ch : frequencyArr) {

			// Count characters with odd occurrence.
			if (ch % 2 != 0)
				oddCharCount++;

			// If more than one character in the string has odd occurrence then
			// palindrome cannot be formed from given string
			if (oddCharCount > 1) {
				str="NO";
				System.out.println(str);
				return str;
			}
		}
		System.out.println(str);
		return str;
	}

	static int[] createFrequencyArray(String testStr) {
		int[] frequencyArr = new int[256];

		char[] charArray = testStr.toCharArray();

		for (char ch : charArray)
			frequencyArr[ch]++;

		return frequencyArr;
	}

	public static void main( String args[]){
		//	permutation.LongestnonrepeatingSubstring("ABCFABAHJUY");
		//permutation.canMakeAPalindrome("apple");
		int arr[]=new int[] {1,2,2,3,1,4};
		//permutation.dutchProblem(arr);
		permutation.minimumsubarraydistinct(arr);
		// printSubArrays(arr, 0, 0);

	}
}