package com.stuypulse.robot.subsystems;

import com.stuypulse.robot.constants.Settings;
import com.stuypulse.stuylib.control.Controller;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Shooter class contains the hardware logic for the Shooter class.
 *
 * <p>Contains a simple feedforward model of the shooter based on the voltage-balance equation and a
 * PID controller to correct for any error.
 *
 * @author Richie Xue 
 */
public abstract class Shooter extends SubsystemBase{
    // Singleton (makes it so that there is only one instance of the Shooter class)
    private static final Shooter instance;

    static {
        if (RobotBase.isReal()) {
            instance = new ShooterImpl();
        }
        else {
            //XXX: Its just a placeholder SimShooter, it doesn't do anything
            instance = new SimShooter();
        }
    }

    public static Shooter getInstance() {
        return instance;
    }
    // Don't worry about anything above 

    /*TODO: Make 3 private fields: 
        targetRPM of tye double,
        feedforward of type SimpleMotorFeedforward,
        feedback of type Controller
        for the last 2, look in the imports to see what they are
    */
    
    public Shooter() {
        /*TODO: Write your constructor, intialize the fields you made
        * Look inside the constants/Settings.java file 
        * to see what you need to initialize the feedforward and feedback
        */
    }

    public void setTargetRPM(double targetRPM) {
        /*TODO:
         * Write a setter for the targetRPM
         * Make sure that the targetRPM is within the bounds of the shooter
         * (MIN_RPM and MAX_RPM) <- make them in the constants/Settings.java file
         * If the targetRPM is within the bounds, set the targetRPM to the targetRPM
         * If the targetRPM is not within the bounds, set the targetRPM to the upper/lower bound
         */
      
    }

    public double getTargetRPM() {
        //TODO: Write a getter for the targetRPM
    }

    /*TODO: Write the following abstract methods (remember nothing in the body, just the signature)
     * getVelocity() of type double
     * setVoltage(double voltage) of type void
     * getVoltage() of type double
    */
    
    // This is a method that will be called every 20ms
    @Override
    public void periodic() {
        //This part I will write out for you guys! :)
        if (getTargetRPM() < Settings.Shooter.MIN_RPM) {
            this.setVoltage(0.0);
        } 
        else {
            // Calculate feedforward and feedback (inputting a desired RPM and outputting needed voltage)
            double ff = feedforward.calculate(getTargetRPM());
            double fb = feedback.update(getTargetRPM(), getVelocity());
            this.setVoltage(ff + fb);
        }
        SmartDashboard.putNumber("Shooter/Target RPM", getTargetRPM());

        // Once implemented, the stuff in periodicallyCalled() will be also called every 20ms
        periodicallyCalled();
    }

    // This is a method that will be called every 20ms, to be implemented in ShooterImpl.java
    public abstract void periodicallyCalled();
}
