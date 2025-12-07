package activities;

public class Activity2 {

	public static void main(String args[]) {
		int[] numbers = {10,77,10,54,-11,10,67,10};
		
		System.out.println("result " +result(numbers) );
		
	}
	
	public static boolean result(int[] numbers) {
		int sum = 30;
		int tempSum = 0;
		
		for (int num : numbers)
		{
			if (num == 10) 
			{
				tempSum = tempSum+num;
			}
		}
		
		
		
		return sum == tempSum;
		
	
		
		
	}
}
