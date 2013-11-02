import lejos.nxt.*;
import lejos.util.Delay;
import java.lang.*;

public class SoundLight
{
   /**
   * @param args
   */
  public static void main(String[] args)
    { 
           
	boolean taskComplete;
	boolean pickupComplete = false;
	boolean dropComplete = false;
    taskComplete = Button.ESCAPE.isPressed();
	  
    while (!taskComplete) {
		Motor.B.setSpeed(45);
	    Motor.A.setSpeed(10);
		Motor.C.setSpeed(35);
	    SoundSensor sound = new SoundSensor(SensorPort.S2);
		LightSensor light = new LightSensor(SensorPort.S1);
       
		
		while (pickupComplete == false) {
			Delay.msDelay(200);
			int soundValue = sound.readValue();
			System.out.println(soundValue);
			if (soundValue > 40)
			   {
				 Motor.B.setSpeed(30);
				 Motor.B.rotate(-120);
				 Motor.C.rotate(90);
				 System.out.println(soundValue);
				 pickupComplete = true;
			   } //if
		} //while pickupComplete
         
        
        while (dropComplete == false) {
			int soundValue = sound.readValue();
			int lightValue = light.getLightValue();
			System.out.println(soundValue);
			while (lightValue > 60) {
				Motor.A.rotate(10);
				lightValue = light.getLightValue();
			} //while
			
			if (soundValue > 40){ 
				Motor.B.rotate(95);
				taskComplete = true;
				dropComplete = true;
			} //if
		} //while dropComplete
		
           
	} //while taskComplete
          
 } //main
        
} //class