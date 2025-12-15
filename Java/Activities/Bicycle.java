package activities;

public class Bicycle implements BicycleParts ,BicycleOperations{
    public int current_speed;
    public int gears;
    
    public Bicycle(int current_speed,int gears) {
    	this.current_speed = current_speed;
    	this.gears = gears;
    	
    }
	@Override
	public void applyBrake(int decrement) {
		
		current_speed = current_speed - decrement;
		System.out.println("Current Speed is " +current_speed);
	}

	@Override
	public void speedUp(int increment) {
		current_speed = current_speed + increment;
		System.out.println("Current Speed is " +current_speed);
		
	}
	
	public void bicycleDesc() {
	    System.out.println("No of gears are "+ gears + "\nSpeed of bicycle is " + maxSpeed);
	}

}
