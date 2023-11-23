package com.stuypulse.robot.commands;

import com.stuypulse.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ShooterSetRPM extends InstantCommand {

    //TODO: Make a field for the shooter and a field for the target RPM

    public ShooterSetRPM(double targetRPM) {
        //TODO: Write the constructor for this command (dont forget to add requirements)
    }

    @Override
    public void initialize() {
        //TODO: Use the shooter's setTargetRPM method to set the target RPM (very similar to ShooterStop.java)
    }
}
