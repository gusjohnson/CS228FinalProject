import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
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
      taskComplete = Button.ESCAPE.isPressed();
	  
	  while (!taskComplete) {
	   Motor.B.setSpeed(45);
	   Motor.A.setSpeed(10);
	   Delay.msDelay(200);
	   SoundSensor sound = new SoundSensor(SensorPort.S2);
	   int soundValue = sound.readValue();
	   System.out.println(soundValue);
       if (soundValue > 40)
	   {
		  Motor.B.setSpeed(30);
		  Motor.B.rotateTo(-90);
		  //System.out.println(soundValue);
		  Motor.A.rotateTo(45);
	   }
		
		soundValue=sound.readValue();
		
		if	(soundValue > 40){ 
		  Motor.B.rotateTo(75);
		  taskComplete = true;
	    }
	   }
	  }
	}