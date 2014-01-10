package de.gruppe2.Tests;

import de.gruppe2.CalibrateSonic;
import lejos.nxt.Button;
import lejos.nxt.Motor;

public class TestMotor {
	public static void main(String[] arg)
	{
		System.out.println("Calibrate horizontal");
		
		
		CalibrateSonic.calibrateVertically();
		
		while(Button.ENTER.isUp())
			Thread.yield();
		
		CalibrateSonic.calibrateHorizontally();
		while(Button.ENTER.isUp())
			Thread.yield();
	}
}