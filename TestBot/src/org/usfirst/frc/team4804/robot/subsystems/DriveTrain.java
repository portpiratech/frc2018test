package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.CimMotor;
import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private CimMotor leftMotor;
	private CimMotor rightMotor;
	
	public DriveTrain(){
		leftMotor = new CimMotor(RobotMap.leftMotorControllerId);
		rightMotor = new CimMotor(RobotMap.rightMotorControllerId);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }
    
    public void tankDrive() {  
    	
    	//variableType variableName = Class.controllerName.getY(hand);
    	double leftY = OI.driverController.getY(Hand.kLeft);
    	double rightY = OI.driverController.getY(Hand.kRight);
    	
    	//motorControlerName.set(controlMode, value);
    	leftMotor.setSpeed(leftY);
    	//rightMotor.setSpeed(rightY);
    }
}

