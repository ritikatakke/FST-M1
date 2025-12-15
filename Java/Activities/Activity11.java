package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> color = new HashMap<Integer, String>();
        color.put(1, "Red");
        color.put(2, "Blue");
        color.put(3, "Green");
        color.put(4, "Black");
        color.put(5, "White");
        
 
      
        System.out.println("The Original map: " + color);
        
     
        color.remove(4);
       
        System.out.println("After removing White: " + color);
        
      
        if(color.containsValue("White")) {
            System.out.println("White exists in the Map");
        } else {
            System.out.println("White does not exist in the Map");
        }
      
        System.out.println("Number of pairs in the Map is: " + color.size());
    

	}

}
