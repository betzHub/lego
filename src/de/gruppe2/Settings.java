package de.gruppe2;

import de.gruppe2.motor.AllWheelPilot;
import de.gruppe2.race.ArbitratorManager;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;

/**
 * This class is responsible for all the settings needed to run the robot.
 */
public class Settings {
	
	public enum Symbol { NONE, L, U, M, Z };
	public enum BridgeState { START, ON_BRIDGE, FOLLOW_LINE, BEFORE_ELEVATOR, END };
	
	public static BridgeState BRIDGE_STATE = BridgeState.START;

	/**
	 * ArbitratorManager to change arbitrators depending on the current level.
	 */
	public static RobotState CURRENT_LEVEL = RobotState.BARCODE;
	public static ArbitratorManager ARBITRATOR_MANAGER;

	public static boolean isRunning = false;
	/*
	// defines if the robot is being relocated
	//public static boolean relocate = false;
	public static boolean raceStarted = false;
	// defines if the robot is currently running or not
	public static boolean isRunning = false;
	*/
	
	public final static int COLOR_TURNTABLE = 395;
	public static String TURNTABLE_BRICK_NAME = "MainGate";
	
	/**
	 * General settings for the robot.
	 */
	public final static double DRIVE_SPEED = 40;
	public final static double ROTATION_SPEED = 40;
	public final static double TRACK_WIDTH = 140;
	public final static double WHEEL_DIAMETER = 56;
	public final static NXTRegulatedMotor MOTOR_LEFT = Motor.C;
	public final static NXTRegulatedMotor MOTOR_RIGHT = Motor.A;
	public final static NXTRegulatedMotor MOTOR_SONIC = Motor.B;

	public static AllWheelPilot PILOT = new AllWheelPilot(WHEEL_DIAMETER, TRACK_WIDTH, MOTOR_LEFT, MOTOR_RIGHT);

	/**
	 * Defining ports for sensors.
	 */
	public final static SensorPort LIGHT_SENSOR_PORT = SensorPort.S2;
	public final static SensorPort SONIC_SENSOR_PORT = SensorPort.S3;
	public final static SensorPort TOUCH_L_SENSOR_PORT = SensorPort.S4;
	//public final static SensorPort TOUCH_R_SENSOR_PORT = SensorPort.S4;

	/**
	 * Initialization of sensors.
	 */
	public static final UltrasonicSensor SONIC_SENSOR = new UltrasonicSensor(SONIC_SENSOR_PORT);
	public static final LightSensor LIGHT_SENSOR = new LightSensor(LIGHT_SENSOR_PORT);
	public static final TouchSensor TOUCH_L = new TouchSensor(TOUCH_L_SENSOR_PORT);
	//public static final TouchSensor TOUCH_R = new TouchSensor(TOUCH_R_SENSOR_PORT);

	/**
	 * Different angle settings.
	 */
	public static int angle = 15;
	public static int motorAAngle = 999;

	/**
	 * Miscellaneous.
	 */
//	public static boolean fromLeft;
//	public static boolean inFirstRow = true;
//	public static boolean atStart = true;
//	public static boolean onColors = false;;
//	public static boolean colorFound = false;
	public static boolean reachedBridge = true;
//	public static boolean motorStalled = false;

	/**
	 * boolean if in obstacle found mode
	 */
	/*public static boolean obstacle = false;
	public static boolean gap = false;
	public static boolean beforeWhip = true;
	public static boolean afterWhip = false;*/

	/**
	 * Saved light sensor settings with sample settings
	 */
	public final static int LIGHT_BLACK_DEFAULT = 330; // Its black if light value is <= this value
	public final static int LIGHT_LINE_DEFAULT = 600;
	public final static int LIGHT_BRIDGE_DEFAULT = 450;	
	public final static int COLOR_DIFFERENCE_THRESHOLD = 100;
	/*public static int light_black = 300;
	public static int light_bridge = 434;
	public static int light_line = 500;
	public static int light_yellow = 480;
	public static int light_red = 460;
	public static int light_green = 415;
	public static int searchedColor;
	public static int color1;*/
	
	public static Symbol detectedSymbol = Symbol.NONE;

	/**
	 * Relative light percents.
	 */
	/*
	public final static int light_bridge_rel = 66;
	public final static int light_yellow_rel = 90;
	public final static int light_red_rel = 80;
	public final static int light_green_rel = 57;

	public static int whipAndBridgeCounter = 0;
	public static boolean buttonPressed = false;
	public static boolean endOfHangBridge = false;
	public static boolean atStartofSlider = true;
	public static boolean afterSlider = false;
	public static boolean parkCompleted = false;
	public static boolean bluetooth = false;
	public static boolean atStartOfTurntable = true;*/
	
	public static boolean readCode = true;
	
	
	public final static double TAPE_FOLLOW_SPEED = 0.20;
	public final static double TAPE_ROTATE_SPEED = 0.25;

	public final static int BRIDGE_HEIGHT_THRESHOLD = 15;
	public final static int MAZE_WALL_DISTANCE_THRESHOLD = 10;
	public final static int RACE_TRACK_WALL_DISTANCE_THRESHOLD = 25;
	
	public static boolean RACE_TRACK_END = false;
}
