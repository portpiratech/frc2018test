package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PickerUpperOfCubes extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private Encoder encoder;
	private TalonSRX puocMotor;
	
	public PickerUpperOfCubes(){
		encoder = new Encoder(RobotMap.encoderChannelA,RobotMap.encoderChannelB);
		puocMotor = new TalonSRX(RobotMap.puocMotorId);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public int getEncoder(){
    	return encoder.get();
    }
    
    public void movePuoc(double speed) {
    	puocMotor.set(ControlMode.PercentOutput, speed);
    }
    
    public boolean cubeHeld() {
    	int encoderMax = 2000;
    	double currentMax = 0.3;
    	
    	if(getEncoder() >= encoderMax || puocMotor.getOutputCurrent() >= currentMax) {
    		return true;
    	} else {
    		return false;
    	}
    }
}

