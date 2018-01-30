package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.SeatMotor;
import org.usfirst.frc.team4804.robot.commands.Grab;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Grabber extends Subsystem {
	//This is a very basic version of grabber's program
	
	private SeatMotor grabberMotor;
	private AnalogTrigger grabberAnalogEncoder;
	private int count;
	private boolean encState;
	
	public Grabber(){
		grabberMotor = new SeatMotor(RobotMap.grabberMotorId);
		grabberAnalogEncoder = new AnalogTrigger(RobotMap.grabberEncoderId);
		grabberAnalogEncoder.setLimitsVoltage(3.5, 5.0);
		
		count = 0;
		encState = getEncoderState();
		
		grabberMotor.getMotor().enableCurrentLimit(true);
		grabberMotor.getMotor().configPeakCurrentLimit(0, 0);
		grabberMotor.getMotor().configContinuousCurrentLimit(1, 500);
		
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
		setDefaultCommand(new Grab());
    }
	
	public void close() {
    	double clamp = OI.operatorController.getY(Hand.kLeft);
    	grabberMotor.setSpeed(clamp);
    	count();
    	
    	SmartDashboard.putNumber("Seat motor encoder index", grabberAnalogEncoder.getIndex());
    	SmartDashboard.putBoolean("Seat motor encoder bool", getEncoderState());
    	SmartDashboard.putNumber("Seat motor encoder count test", count);
    	SmartDashboard.putNumber("seat motor output current ", getMotorCurrent());
	}

	public double getMotorCurrent() {
		return grabberMotor.getMotor().getOutputCurrent();
	}
	
	public boolean getEncoderState(){
		 return grabberAnalogEncoder.getInWindow();
	}
	
	public void count()  {
		if(encState != getEncoderState() && getEncoderState() == true) { 
			if(Math.signum(getMotorCurrent()) == 1.0) {
				count++;
			} else if(Math.signum(getMotorCurrent()) == -1.0) {
				count--;
			}
		}
		encState = getEncoderState();
		//CONFUSED AND NOT WORKING SEND HELP
	}
	

}

