package com.students.tests;

import com.google.common.collect.Sets; 
import java.util.Set;

  
public class SamplePgms {
	
	static void deleteno(int val, int d) 
	{
		//Delete no from begining
		String deleteStart = "";
		for(int i=0;i<=Integer.toString(val).length()-1;i++){
			if(i==(d-1)){
				System.out.println();
			}else{
				deleteStart = deleteStart+Integer.toString(val).charAt(i);
			}
		}
		
		System.out.println("After deleting no from begining :"+deleteStart);
		
		//Delete no from end
		String deleteEnd = "";
		for(int i=Integer.toString(val).length()-1;i>=0;i--){
			if(i==(d-2)){
				System.out.println();
			}else{
				char temp = Integer.toString(val).charAt(i);
				deleteEnd = deleteEnd+temp;
			}
		}
		
		System.out.println("After deleting no from end :"+deleteEnd);
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		deleteno(1234, 3); 
	} 
	
}