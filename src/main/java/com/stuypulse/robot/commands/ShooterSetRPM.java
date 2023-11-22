package com.stuypulse.robot.commands;

import com.stuypulse.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ShooterSetRPM extends InstantCommand {

    private Shooter shooter;
    private double targetRPM;

    public ShooterSetRPM(double targetRPM) {
        shooter = Shooter.getInstance();
        this.targetRPM = targetRPM;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.setShooterRPM(targetRPM);
    }
}
