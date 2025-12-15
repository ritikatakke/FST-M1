package activities;

public class MountainBike extends Bicycle{
 public int seat_height;
	public MountainBike(int current_speed, int gears,int seat_height) {
		super(current_speed, gears);
		this.seat_height = seat_height;
		// TODO Auto-generated constructor stub
	}
	
	public void setHeight(int newValue) {
	    seat_height = newValue;
	}
	public void bicycleDesc() {
	    System.out.println("seat_height of bicycle is " + seat_height);
	}
}
