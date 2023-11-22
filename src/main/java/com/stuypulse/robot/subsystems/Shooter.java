package com.stuypulse.robot.subsystems;

import com.stuypulse.robot.constants.Settings;

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
    // Singleton
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

    private double targetRPM;

    
    public Shooter() {
        this.targetRPM = 0.0;

    }

    public void setTargetRPM(double targetRPM) {
        if (targetRPM < Settings.Shooter.MIN_RPM) {
            this.targetRPM = 0.0;
        } 
        else if (targetRPM > Settings.Shooter.MAX_RPM) {
            this.targetRPM = Settings.Shooter.MAX_RPM;
        }
        else {
            this.targetRPM = targetRPM;
        }
    }

    public double getTargetRPM() {
        return this.targetRPM;
    }

    public abstract double getVelocity();
    
    @Override
    public void periodic() {
        SmartDashboard.putNumber(getName(), targetRPM);
        periodicallyCalled();
    }

    public abstract void periodicallyCalled();

    public void setShooterRPM(double d) {
    }
}
