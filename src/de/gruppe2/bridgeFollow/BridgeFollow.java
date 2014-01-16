package de.gruppe2.bridgeFollow;

import java.util.LinkedList;

import lejos.nxt.Button;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.comm.RConsole;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;
import de.gruppe2.Settings;
import de.gruppe2.Settings.BridgeState;

public class BridgeFollow implements Behavior {
	static UltrasonicSensor sonic = Settings.SONIC_SENSOR;
	
	private boolean suppressed = false;

	@Override
	public boolean takeControl() {
		return Settings.BRIDGE_STATE == BridgeState.FOLLOW_LINE;
	}

	@Override
	public void action() {
		suppressed = false;
		System.out.println("drive near ground");
		
		Settings.PILOT.setTravelSpeed(Settings.PILOT.getMaxTravelSpeed() * 0.5);
		Settings.PILOT.forward();
		
		int steer = 0;
		int lastLightValue = 0;
		int lightValue = 0;
		long startTime = 0;
		while (!suppressed) {
			lastLightValue = lightValue;
			lightValue = Settings.LIGHT_SENSOR.getNormalizedLightValue();
			
			if(lightValue > 500 && lastLightValue > 500) {
				System.out.println("stop - blue " + lightValue);
				Settings.BRIDGE_STATE = BridgeState.BEFORE_ELEVATOR;
				Settings.PILOT.stop();
			} else if(Math.abs(lastLightValue - lightValue) > 30) {
				if(startTime > 0) {
					if((System.currentTimeMillis() - startTime) > 1500) {
						if(lightValue > 420) {
							// Still on the bridge
							System.out.println("Still on bridge: " + lightValue);
						} else {
							Settings.BRIDGE_STATE = BridgeState.BEFORE_ELEVATOR;
							System.out.println("stop - distance " + lightValue + " " + lastLightValue);
							Settings.PILOT.stop();
						}
						startTime = 0;
					}
				} else {
					startTime = System.currentTimeMillis();
				}
			}
			if(sonic.getDistance() > Settings.BRIDGE_HEIGHT_THRESHOLD)
			{
				// Robot is near ground
				if(steer > 0) steer = -15;
				steer -= 1;
				if(steer < -25) steer = -25;
				
			} else {
				// Robot is minimal away from ground
				if(steer < 0) steer = 15;
				steer += 1;
				
				if(steer > 20) steer = 20;
			}
			
			Settings.PILOT.steer(steer);
			Thread.yield();
		}
		
		Settings.PILOT.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
}
