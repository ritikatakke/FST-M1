package activities;

public class Activity6 {
	
	public static void main(String args[]) {
		
		Plane plane = new Plane(10);
		
		plane.onboard("Ritika");
		plane.onboard("Tausif");
		plane.onboard("varun");
		plane.onboard("Sayu");
		
		System.out.println("The plane take off at "+plane.takeOff());
		
		System.out.println("List of passenger onboard in the plane "+plane.getPassengers());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		plane.land();
		
		System.out.println("The plane landed at "+ plane.getLastTimeLanded());
		
		
		
		
		
		
		
		
		
	}

}
