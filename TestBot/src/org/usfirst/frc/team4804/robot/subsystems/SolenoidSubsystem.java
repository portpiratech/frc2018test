package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.PistonStop;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * The Piston subsystem incorporates two solenoids wired to the
 * pneumatics control module (PCM).
 */
public class SolenoidSubsystem extends Subsystem {
	
	private DoubleSolenoid cannonSolenoid;
	public double firingDelay = 0.5;
	
	public SolenoidSubsystem() {
		super();
		cannonSolenoid = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.solenoid2_port1, RobotMap.solenoid1_port2); //PCM ID 1, Solenoid ports 1,2
	}


	public void initDefaultCommand() {
		//setDefaultCommand(new *);
		setDefaultCommand(new PistonStop());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
	}
	
	// Cannon solenoid (Launcher)
	public void extendLauncher() {
		cannonSolenoid.set(Value.kForward);
	}
	
	public void retractLauncher(){
		cannonSolenoid.set(Value.kReverse);
	}
	
	public void stopLauncher() {
		cannonSolenoid.set(Value.kOff);
	}
	
	/* last year's code
	public void extendArms() {
		solenoid2.set(Value.kForward);
	}
	
	public void retractArms() {
		solenoid2.set(Value.kReverse);
	}
	
	public void stopArms() {
		solenoid2.set(Value.kOff);
	}
	*/
}
