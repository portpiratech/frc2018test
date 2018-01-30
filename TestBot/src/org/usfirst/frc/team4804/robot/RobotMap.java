package org.usfirst.frc.team4804.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//XBox controller IDs
	public static int xboxControlId = 0;
	public static int leftStickXId = 0;
	public static int rightStickXId = 4;
	public static int rightStickYId = 5;
	public static int leftStickYId = 1;
	public static final int DRIVER_CONTROLLER_ID = 0;
	public static final int OPERATOR_CONTROLLER_ID = 1;
	
	//CANbus device IDs
	public static int leftMotorControllerId = 11;
	public static int rightMotorControllerId = 14;
	public static int actuatorMotorId = 13;
	public static final int PCM_ID = 1; //Compressor/Pneumatics Control Module (used for DoubleSolenoids)
	public static int grabberMotorId = 12;
	
	//Analog device IDs
	public static int actuatorPotentiometerId = 0;
	
	//Digital device IDs (DIO)
	public static int encoderChannelA = 0;
	public static int encoderChannelB = 1;
	
	//Solenoid port IDs
	public static int solenoid1_port1 = 0; //DoubleSolenoid
	public static int solenoid1_port2 = 1; //DoubleSolenoid
	public static int solenoid2_port1 = 2; //DoubleSolenoid
	public static int solenoid2_port2 = 3; //DoubleSolenoid
	
	public static double joystickTolerance = 0.15;
	// DriveTrain:
	public static double driveSpeedMultiplier = 0.8;
	public static double driveSpeedDpadMultiplier = 0.8;
	public static double autoApproachSpeedMultiplier = 0.50;
	public static double distanceToleranceMeters = 0.02;
	public static double distanceSetpointMeters = 0.5;
}
