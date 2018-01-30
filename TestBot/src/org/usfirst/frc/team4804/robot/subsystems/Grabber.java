package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.SeatMotor;
import org.usfirst.frc.team4804.robot.commands.Grab;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
	//This is a very basic version of grabber's program
	
	private SeatMotor grabberMotor;
	private AnalogTrigger grabberVoltage;
	
	public Grabber(){
		grabberMotor = new SeatMotor(RobotMap.grabberMotorId);
		grabberVoltage = new AnalogTrigger(0);
		grabberVoltage.setLimitsVoltage(3.5, 5.0);
		
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
		setDefaultCommand(new Grab());
    }
	
	public void close() {
    	double clamp = OI.operatorController.getY(Hand.kLeft);
    	grabberMotor.setSpeed(clamp);
	}
	
	public boolean getEncoderValue(){
		 boolean inWindow = grabberVoltage.getInWindow();
		 return inWindow;
		
	}
	

}

