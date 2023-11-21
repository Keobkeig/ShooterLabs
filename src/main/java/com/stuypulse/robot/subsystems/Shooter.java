package com.stuypulse.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.stuypulse.robot.constants.Settings;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    private double targetRPM;
    private final PIDFlywheel flywheel;
    
    public Shooter() {
        flywheel = new PIDFlywheel(
            new CANSparkMax(1, CANSparkMax.MotorType.kBrushless),
            Settings.Shooter.ShooterFF.getController(),
            Settings.Shooter.ShooterPID.getController()
        );
        targetRPM = 0.0;
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

    public void setFlyWheelRPM(double targetRPM) {
        if (targetRPM < Settings.Shooter.MIN_RPM) {
            flywheel.stop();
        } 
        else if (targetRPM > Settings.Shooter.MAX_RPM) {
            flywheel.setVelocity(Settings.Shooter.MAX_RPM);
        }
        else {
            flywheel.setVelocity(targetRPM);
        }
    }

    public double getFlyWheelRPM() {
        return flywheel.getVelocity();
    }

    public boolean isReady() {
        return Math.abs(getFlyWheelRPM() - getTargetRPM()) < Settings.Shooter.MAX_RPM_ERROR;
    }

    @Override
    public void periodic() {
        double setpoint = getTargetRPM();
        if (setpoint < Settings.Shooter.MIN_RPM) {
            flywheel.stop();
        } 
        else {
            flywheel.setVelocity(setpoint);
        }
        flywheel.periodic();
    }
}
