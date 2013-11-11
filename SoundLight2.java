import lejos.nxt.*;
import lejos.util.Delay;
import java.lang.*;

public class SoundLight2
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
			Motor.C.setSpeed(35);
			SoundSensor sound = new SoundSensor(SensorPort.S2);
			LightSensor light = new LightSensor(SensorPort.S1);
			LightSensor light2 = new LightSensor(SensorPort.S3);
			Motor.C.rotate(-70);
			Delay.msDelay(200);
			int soundValue = sound.readValue();
		
			//move arm to above ball
			while (soundValue < 60) {
				soundValue = sound.readValue();
				int lightValue = light.getLightValue();
				int lightValue2 = light2.getLightValue();
				Delay.msDelay(200);
				System.out.println(soundValue);
			
				if (lightValue > 60) {
					Motor.A.rotate(10);
					lightValue = light.getLightValue();
				} 
			
				else if (lightValue2 > 60) {
					Motor.A.rotate(-10);
					lightValue2 = light2.getLightValue();
				} 
			
			} //while
		
			//lower arm, pick up the ball, raise arm
			Motor.C.rotate(70);
			Motor.B.setSpeed(30);
			Motor.B.rotate(-90);
			Motor.C.rotate(-70);
			soundValue = sound.readValue();
			System.out.println(soundValue);
				
         
			//move arm to target 
			while (soundValue < 60) {
				soundValue = sound.readValue();
				int lightValue = light.getLightValue();
				int lightValue2 = light2.getLightValue();
				System.out.println(soundValue);
			
				if (lightValue > 60){
					Motor.A.rotate(10);
					lightValue = light.getLightValue();
				} 
			
				else if (lightValue2 > 60) {
					Motor.A.rotate(-10);
					lightValue2 = light2.getLightValue();
				} 
			
			} //while
			 
			//drop the ball at target  
			Motor.B.rotate(95);
			taskComplete = true;		
           
		} //while taskComplete
          
	}//main
        
}//class