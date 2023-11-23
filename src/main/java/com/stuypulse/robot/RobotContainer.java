/************************ PROJECT PHIL ************************/
/* Copyright (c) 2023 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot;

import com.stuypulse.robot.commands.ShooterRingShot;
import com.stuypulse.robot.commands.ShooterSetRPM;
import com.stuypulse.robot.commands.ShooterStop;
import com.stuypulse.robot.commands.auton.DoNothingAuton;
import com.stuypulse.robot.constants.Ports;
import com.stuypulse.robot.subsystems.Shooter;
import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.input.gamepads.AutoGamepad;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

    // Gamepads
    public final Gamepad driver = new AutoGamepad(Ports.Gamepad.DRIVER);
    public final Gamepad operator = new AutoGamepad(Ports.Gamepad.OPERATOR);
    
    // Subsystem
    //TODO: Make a field for the shooter, and set it equal to the instance of the shooter (hint: use the getInstance method)

    // Autons
    private static SendableChooser<Command> autonChooser = new SendableChooser<>();

    // Robot container

    public RobotContainer() {
        configureDefaultCommands();
        configureButtonBindings();
        configureAutons();
    }

    /****************/
    /*** DEFAULTS ***/
    /****************/

    private void configureDefaultCommands() {
        //XXX: This is how you make a default command for a subsystem
        shooter.setDefaultCommand(new ShooterStop(shooter));
    }

    /***************/
    /*** BUTTONS ***/
    /***************/

    private void configureButtonBindings() {
        // Driver
        /*TODO: Make a button for the driver's top button and left button
            * 
            * The top button should set the shooter's target RPM to 1000
            * The left button should run a ShooterRingShot command
            * 
            * Hint: Use the ShooterSetRPM and ShooterRingShot commands
            * 
            * Hint: Use the onTrue method for the top button and the onFalse method for the left button
            * 
            * Hint: Use the shooter field you made earlier as the parameter for the ShooterSetRPM and ShooterRingShot commands
            * 
            * Use the button binding code of ShooterStop below as a guide for writing the 2 button bindings
            */
        driver.getBottomButton()
            .onFalse(new ShooterStop(shooter));

    }

    /**************/
    /*** AUTONS ***/
    /**************/

    public void configureAutons() {
        autonChooser.setDefaultOption("Do Nothing", new DoNothingAuton());

        SmartDashboard.putData("Autonomous", autonChooser);
    }

    public Command getAutonomousCommand() {
        return autonChooser.getSelected();
    }
}
