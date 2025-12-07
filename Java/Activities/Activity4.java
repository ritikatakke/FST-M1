package activities;

public class Activity4 {
	
	public static void main(String args[]) {
		
		int[] array = {13,76,45,788,12,34,45,37,89,90};
		System.out.println("Array Before Sorting");
		for (int num : array) {
			System.out.println(num);
		
		}
		
		int length = array.length;
		
		
		
		for (int i=1; i<length;i++) {
			
			int key = array[i];
			int j = i-1;
			
			while(j>=0 && array[j]>key) {
				array[j+1]= array[j];
				j=j-1;
				
			}
			array[j+1]= key;
			
			
		}
		
		System.out.println("Sorted Array");
		for (int num : array) {
			System.out.println(num);
		
		}
		
		
		
		
	}

}
