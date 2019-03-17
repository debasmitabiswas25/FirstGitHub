package com.debs;
import java.util.*;

public class RecursiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//calling printSum
         /*int result=printSum(5);
		 System.out.println("Answer is "+ result);*/
		
		//calling permutationFinder
		
		System.out.println(permutationFinder("AB"));

	}
	
	//Objective to print sum of 5+4+3+2+1 = 15
	/*public static int printSum(int number){
	 if(number == 1)
	 {
		 System.out.println("returned 1");
		 return 1; }
	 else{
		 System.out.println(number +" printSum("+ number + -1  +")");
		return number + printSum(number-1);} }
	**/
	//Objective to find the set in words
	public static Set<String> permutationFinder(String str){
 		
     Set<String> perm=new HashSet<String>();
    
	 if(str==null)
	 { return null; }
	 else if(str.length()==0)
	 {  perm.add(""); return perm;}
	 else {
		 char initial=str.charAt(0);  //initial char
		 String rem=str.substring(1); //rem string
		 
		
		 System.out.println(" permutationFinder("+rem+")");
		 Set<String> words= permutationFinder(rem); 
		 
		 System.out.println("words" + words);
		 
		 for (String strNew : words) {
        	 System.out.println("strNew "+strNew+" strNew LENGTH "+strNew.length());
          for (int i = 0;i<=strNew.length();i++){ 
        	System.out.println("value of strNew "+strNew); 
        	System.out.println("value of initial "+initial); 
            System.out.println("value of i "+i);
          
            perm.add(charInsert(strNew, initial, i));	 
	 }	 
	 }
  }
	 return perm;
}
	 public static String charInsert(String str, char c, int j) {
	        String begin = str.substring(0, j);  //substring(int beginindex,int endindex)
	        System.out.println("begin "+begin);
	        String end = str.substring(j);   //substring(int beginindex)
	         
	        System.out.println("end "+end); //
	        
	        System.out.println("return from charInsert "+begin+c+end);  
	        return begin + c + end;
	    }
}