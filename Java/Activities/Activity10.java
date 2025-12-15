package activities;

import java.util.HashSet;

public class Activity10 {
	
	public static void main(String args[]) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("Rits");
		hs.add("Jiya");
		hs.add("Riya");
		hs.add("Ray");
		hs.add("jay");
		hs.add("Siya");
		
		System.out.println("The Size of Hash Set is "+hs.size());
		
		hs.remove("jay");
		
		hs.remove("priya");
		
		 if( hs.contains("Riya")) {
			 System.out.println("The HashSet contain given Name");
			
		 }
		 else
		 {
			 System.out.println("The HashSet does not contain given Name");
				 
		 }
		
		 System.out.println("The updated HashSet:");
		 
		 for(String name : hs) {
			 System.out.println(name); 
		 }
		
		
	}

}
