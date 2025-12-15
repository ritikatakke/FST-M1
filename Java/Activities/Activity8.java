package activities;

public class Activity8 {

	public static void main(String[] args) throws CustomException {
		Activity8 act = new Activity8();
		act.exceptionTest("Hello Ritika");
		act.exceptionTest(null);
		// TODO Auto-generated method stub

	}
	
	public void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null.Please Enter String Value");
        } else {
            System.out.println(str);
        }
    }

}
