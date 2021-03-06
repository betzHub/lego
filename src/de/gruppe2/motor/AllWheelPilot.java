package de.gruppe2.motor;

import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class AllWheelPilot extends DifferentialPilot {

	private  RegulatedMotor leftMotor;
	private  RegulatedMotor rightMotor;
	
	private final static float ROTATE_FIX = 1.5f;
	private final static float STEER_FIX = 1.5f;
	
	public AllWheelPilot(final double wheelDiameter, final double trackWidth, final RegulatedMotor leftMotor,
			final RegulatedMotor rightMotor) {
		super(wheelDiameter, trackWidth, leftMotor, rightMotor);
		
		this.leftMotor = leftMotor;
		this.rightMotor = rightMotor;
	}

	public AllWheelPilot(final double wheelDiameter, final double trackWidth, final RegulatedMotor leftMotor,
			final RegulatedMotor rightMotor, final boolean reverse) {
		super(wheelDiameter, trackWidth, leftMotor, rightMotor, reverse);
		
		this.leftMotor = leftMotor;
		this.rightMotor = rightMotor;
	}

	public AllWheelPilot(double leftWheelDiameter, double rightWheelDiameter, double trackWidth,
			RegulatedMotor leftMotor, RegulatedMotor rightMotor, boolean reverse) {
		super(leftWheelDiameter, rightWheelDiameter, trackWidth, leftMotor, rightMotor, reverse);
		
		this.leftMotor = leftMotor;
		this.rightMotor = rightMotor;
	}
	
	public void rotate(double angle) {		
		rotate(angle, false);
	}
	
	public void rotate(double angle, boolean immediateReturn) {		
		super.rotate(angle * ROTATE_FIX, immediateReturn);
	}
	
	public void steer(final double turnRate, double angle) {
		steer(turnRate, angle, false);
	}
	
	public void steer(final double turnRate, double angle, boolean immediateReturn) {
		super.steer(turnRate, angle * STEER_FIX, immediateReturn);
	}

}
