package activities;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Addable ad1 = (n1, n2) -> (n1 + n2);
        System.out.println(ad1.add(22, 20));
        
        Addable ad2 = (int n1, int n2) -> {
            return (n1 + n2);
        };
        System.out.println(ad2.add(100, 250));
	}


}
