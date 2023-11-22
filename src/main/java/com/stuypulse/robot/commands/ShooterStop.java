package com.stuypulse.robot.commands;

import com.stuypulse.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ShooterStop extends InstantCommand {

    private Shooter shooter;

    public ShooterStop(Shooter shooter) {
        shooter = Shooter.getInstance();
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.setTargetRPM(0.0);
    }
}
