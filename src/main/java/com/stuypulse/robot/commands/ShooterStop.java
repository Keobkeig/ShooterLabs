package com.stuypulse.robot.commands;

import com.stuypulse.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * ShooterStop command stops the shooter. Use this command when you want to stop the shooter.
 * 
 * <p>It does this by setting the target RPM to 0. Use this completed command as a guide for writing the other commands.
 * 
 * @see Shooter
 * @see ShooterImpl
 * @see ShooterSetRPM
 */
public class ShooterStop extends InstantCommand {

    //XXX:Notice the use of the Shooter class instead of ShooterImpl
    private Shooter shooter;

    public ShooterStop(Shooter shooter) {
        //XXX:Notice how we use the singleton instance of Shooter here instead of creating a new one
        shooter = Shooter.getInstance();
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        //XXX: Notice how it is USING METHODS WE WROTE IN Shooter instead of writing the code to stop in here
        shooter.setTargetRPM(0.0);
    }
}
