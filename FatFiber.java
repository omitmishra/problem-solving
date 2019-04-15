

import java.util.ArrayList;
import java.util.Scanner;

public class FatFiber {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		String str1[]=new String[n];
		String str[]=new String[n];
		//boolean flag=false;
		for(int i=0;i<n;i++){
			str1[i]=sc.next();
		}
		for(int i=0;i<n;i++){
			if(str1[i].startsWith("FAT"))
				str[i]="FAT";
			if(str1[i].startsWith("FIBER"))
				str[i]="FIBER";
			if(str1[i].startsWith("CARB"))
				str[i]="CARB";
		}
		int i=0,k=0,j=0;
		String list[]=new String[n];
		for(int y=0;y<list.length;y++){
			list[y]="-";
		}
		for( i=0;i<n-2;i++){
			if(str[i]!="0"){
				for( j=i+1;j<n;j++){
					if(str[j]!="0"){
						for( k=j+1;k<n;k++){
							if((str[i].equals(str[j]) && str[i]!="0" && str[k]!="0" )
									||(str[i].equals(str[k]) && str[i]!="0" && str[j]!="0")
									||(str[j].equals(str[k]) &&str[j]!="0" && str[i]!="0")){
								list[k]=str1[i]+":"+str1[j]+":"+str1[k];
								str[i]="0";
								str[j]="0";
								str[k]="0";
								
							}
							
						}
					}
					
				}
			}

		}

		for(int y=0;y<list.length;y++){
			System.out.print(list[y]);
		}
		

	}
}