package com.debs;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyFirstClass {

	/**
	 * Java Program to find all permutations of a String
	 * @author pankaj
	 *
	 */
	    public static Set<String> permutationFinder(String str) {
	        Set<String> perm = new HashSet<String>();
	        //Handling error scenarios
	    
	       if (str.length() == 0) {
	            perm.add("");//perm=[]
	            System.out.println("inside str.length()==0 "+perm);
	            return perm;
	            
	      }
	       else {
	        char initial = str.charAt(0); // first character
	        System.out.println("initial "+initial);
	        String rem = str.substring(1); // Full string without first character
	        System.out.println("rem "+rem);
	        System.out.println("permutationFinder("+rem+")");
	        Set<String> words = permutationFinder(rem);
	        
	        for(String strNew:words)
	        {
	         for(int i=0;i<=strNew.length();i++)
	         {
	         perm.add(charInsert(strNew,initial,i));
	        }
	        } 
	        return perm;
	          
	        }
	       
	        
	    }

	    public static String charInsert(String str, char c, int j) {
	        String begin = str.substring(0, j);  
	        System.out.println("begin "+begin); //
	        String end = str.substring(j);  
	         
	        System.out.println("end "+end); //
	        
	        System.out.println("return from charInsert "+begin+c+end);  // B
	        return begin + c + end;
	    }

	    public static void main(String[] args) {
	        String s = "AAC";
	        String s1 = "ABC";
	        String s2 = "ABCD";
	       // System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
	        System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder("ac"));
	        //System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
	    }
	}
	