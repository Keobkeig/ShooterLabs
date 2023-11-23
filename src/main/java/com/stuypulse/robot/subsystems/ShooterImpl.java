package com.stuypulse.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.stuypulse.robot.constants.Ports;

/**
 * ShooterImpl class contains the hardware logic for the Shooter class.
 *
 * <p>Contains a simple feedforward model of the shooter based on the voltage-balance equation and a
 * PID controller to correct for any error.
 *
 * @author Richie Xue 
 */
public class ShooterImpl extends Shooter {
    //TODO: Make 2 fields: motor (CANSparkMax) & encoder (RelativeEncoder)

    //The constructor has been written for you, but you need to fill in the fields
    public ShooterImpl() {
        super();

        /*TODO: Initialize the motor and encoder fields
         * Hover over CANSparkMax, and RelativeEncoder to see what parameters you need to pass in
         * CANSparkMax requires a port number and a motor type
         * The port number can be obtained from Ports.java in the constants folder
         * The motor type is either MotorType.kBrushless or MotorType.kBrushed (we are using Brushless)
         * 
         * RelativeEncoder's initialization requries a CANSparkMax object and then using its getEncoder() method
        */
        
        this.motor = new CANSparkMax(, );
        this.encoder = motor.getEncoder();
    }

    //TODO: Use one of the encoder's methods to get the velocity
    public double getVelocity() {
        
    }

    @Override
    public void setVoltage(double voltage) {
        //TODO: Use the motor's setVoltage method to set the voltage
    }   

    @Override
    public double getVoltage() {
        //TODO: Use the motor's getAppliedOutput method to get the voltage
    }

    @Override
    public void periodicallyCalled() {
        /*In this method, you should update the SmartDashboard (a place to see values on the driver station)
         * You can use the SmartDashboard.putNumber method to put a number on the SmartDashboard (look at the 2 already there)
         * The first parameter is the name of the value, the second parameter is the value itself
         * TODO:Make 2 values: one for the velocity and one for the voltage (write it the line below) 
        */
        SmartDashboard.putNumber("Shooter/Error", getTargetRPM() - getVelocity());
    }   
}
