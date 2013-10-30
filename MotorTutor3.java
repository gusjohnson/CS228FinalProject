 
 import lejos.nxt.Button;
 import lejos.nxt.LCD;
 import lejos.nxt.Motor;
 

 /**
  * Simplest 3 motor commands
  * @author owner.GLASSEY
  *
  */
 public class MotorTutor3
 {
     /**
       * @param args
       */
      public static void main(String[] args)
    {
           LCD.drawString("Program 1", 0, 0);
           Button.waitForAnyPress();
           LCD.clear();
           Motor.C.setSpeed(30);
		   Motor.C.rotateTo(-75);
		   Button.waitForAnyPress();
		   Motor.C.rotateTo(75);
           LCD.drawString("FORWARD",0,0);
           Button.waitForAnyPress();
           
	}
}