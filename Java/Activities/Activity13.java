package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
       
        
        System.out.print("Enter integers please ");
        System.out.println("Enter any alphabet to terminate ");
 
        while(sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        Random indexVal = new Random();
        
        Integer numArray[] = list.toArray(new Integer[0]);
        int index = indexVal.nextInt(numArray.length);
        System.out.println("Index value generated: " + index);
        System.out.println("Value in arary at generated index: " + numArray[index]);
 
        sc.close();

	}

}
