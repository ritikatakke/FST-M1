package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> myList = new ArrayList<String>() ;
		myList.add("Ritika");
		myList.add("Sayu");
		myList.add("Juee");
		myList.add("Nishu");
		myList.add("Aish");
		
		for(String name : myList) {
			System.out.println(name);
		}
	 System.out.println("Third Name in the List is " +myList.get(2));
	 
	 if( myList.contains("S3ayu")) {
		 System.out.println("The List contain given Name");
		
	 }
	 else
	 {
		 System.out.println("The List does not contain given Name");
			 
	 }
	
	 System.out.println("The Size of List is "+myList.size());
		
	 myList.remove("Aish");
	 System.out.println("The Size of List is "+myList.size());
	

	}

}
