package com.stuypulse.robot.subsystems;
import com.stuypulse.robot.constants.Settings;
import com.stuypulse.stuylib.control.Controller;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

/**
 * A utility class meant for controlling a flywheel system (shooter, feeder, etc.) by driving it to
 * a reference rotations per minute.
 *
 * <p>Stores a simple feedforward model of the shooter based on the voltage-balance equation and a
 * PID controller to correct for any error.
 *
 * @author Richie Xue 
 * referenced off of Excelsior PIDFlywheel
 */
public class PIDFlywheel extends SubsystemBase {

    private double targetRPM;

    private final CANSparkMax motor;
    private final RelativeEncoder encoder;

    private final SimpleMotorFeedforward feedforward;
    private final Controller feedback;

    public PIDFlywheel(CANSparkMax motor, SimpleMotorFeedforward feedforward, Controller feedback) {
        this.motor = motor;
        this.encoder = motor.getEncoder();

        this.targetRPM = 0.0;

        this.feedforward = feedforward;
        this.feedback = feedback;
    }

    public void stop() {
        setVelocity(0);
    }

    public void setVelocity(double targetRPM) {
        this.targetRPM = targetRPM;
    }

    public double getVelocity() {
        return encoder.getVelocity();
    }

    public void periodic() {
        if (this.targetRPM < Settings.Shooter.MIN_RPM) {
                motor.setVoltage(0);
        } 
        else {
            double ff = feedforward.calculate(this.targetRPM);
            double fb = feedback.update(this.targetRPM, getVelocity());
            motor.setVoltage(ff + fb);
        }
    }
}
