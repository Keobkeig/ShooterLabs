package com.stuypulse.robot.commands;

import com.stuypulse.robot.constants.Settings;
import com.stuypulse.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

//SequentialCommandGroups are commands that run other made commands in a sequence
public class ShooterRingShot extends SequentialCommandGroup {

    public ShooterRingShot(Shooter shooter) {
        //XXX: Notice the syntax, we are adding commands to this command's construtor, no need to make a shooter field or write an initialize method
        addCommands(new ShooterSetRPM(Settings.Shooter.RING_RPM));
    }
}
