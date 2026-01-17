package Project;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.time.Duration;
import java.util.Arrays;

import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;


import io.appium.java_client.AppiumDriver;

public class ActionBase {
	
	public static PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
	
	public static void doSwipe(AppiumDriver driver, Point start, Point end,int duration) {
		
		Sequence swipe = new Sequence(finger,1);
		swipe.addAction(finger.createPointerMove(ofMillis(0),viewport(),start.getX(),start.getY()));
		swipe.addAction(finger.createPointerDown(LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(ofMillis(duration),viewport(),end.getX(),end.getY()));
		swipe.addAction(finger.createPointerUp(LEFT.asArg()));
		// perform action
		driver.perform(Arrays.asList(swipe));
	
	}
	
	public static void doLongPress(AppiumDriver driver, Point start) {
		  Sequence longPress = new Sequence(finger, 1);

	        // Move to position
	        longPress.addAction(finger.createPointerMove(
	                Duration.ZERO,
	                PointerInput.Origin.viewport(),
	                start.getX(),
	                start.getY()
	        ));

	        // Finger down
	        longPress.addAction(
	                finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())
	        );

	        // ✅ PAUSE belongs to Sequence
	        longPress.addAction(
	                new org.openqa.selenium.interactions.Pause(finger, Duration.ofSeconds(2))
	        );

	        // Finger up
	        longPress.addAction(
	                finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())
	        );

	        driver.perform(Arrays.asList(longPress));	}
	

}
