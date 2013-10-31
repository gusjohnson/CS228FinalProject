import lejos.nxt.*;
import lejos.util.Delay;
import java.lang.*;

/**
 8  * Simplest 3 motor commands
 9  * @author owner.GLASSEY
10  *
11  */

public class SoundTesting
{
   /**
   * @param args
   */

   public static void main(String[] args)
    { 
	   
	  boolean taskComplete;
	  boolean clawClosed;
	  //boolean clawOpened;
      taskComplete = Button.ESCAPE.isPressed();
	  
	  while (!taskComplete) {
	   
	   Motor.B.setSpeed(45);
	   Motor.A.setSpeed(10);
	   Delay.msDelay(200);
	   SoundSensor sound = new SoundSensor(SensorPort.S2);
	   int soundValue = sound.readValue();
	   System.out.println(soundValue);
       
		while (!clawClosed) {
		   if (soundValue > 70)
		   {
			  Motor.B.setSpeed(30);
			  Motor.B.rotate(-130);
			  //System.out.println(soundValue);
			  Motor.A.rotate(140);
		   } //if
		   clawClosed = true;
	   } //while
		
		int soundValue2=sound.readValue();
		
		if	(soundValue2 > 70){ 
		  Motor.B.rotate(130);
		  Motor.A.rotate(-140);
		  taskComplete = true;
		} //if
	    
	   } // while (!taskComplete)
	  } //main
	} //class