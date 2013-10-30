import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.*;

public class LightTest {
  public static void main(String[] args) throws Exception {
    LightSensor light = new LightSensor(SensorPort.S1);

	Motor.A.setSpeed(10);
	//LCD.drawInt(light.getLightValue(), 4, 0, 0);
	//light.getLightValue();
    while (light.getLightValue() > 25) {
	Motor.A.rotateTo(45);
	light.getLightValue();}
    //System.out.println("Success");	
	Button.waitForAnyPress();
  }
}