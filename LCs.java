/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Lcs {
    public static void main(String args[] ) throws Exception {
  
        //Scanner
        Scanner s = new Scanner(System.in);
      //  s.n
        String X = s.next();               // Reading input from STDIN
     //   System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
         String Y= s.next();
        
       //
        // s.next()
      try {
		Lcs.getLongestCommonSubstring(X.toLowerCase(),Y.toLowerCase());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    } 
        // Write your code here
    
   public static int getLongestCommonSubstring(String a, String b){
	int m = a.length();
	int n = b.length();
 
	int max = 0;
 
	int[][] dp = new int[m][n];
 
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			if(a.charAt(i) == b.charAt(j)){
				if(i==0 || j==0){
					dp[i][j]=1;
				}else{
					dp[i][j] = dp[i-1][j-1]+1;
				}
 
				if(max < dp[i][j])
					max = dp[i][j];
			}
 
		}
	}
   System.out.println(max);
	return max;
    
   }   
}
