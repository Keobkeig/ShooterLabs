# ShooterLabs

## Guide:
This will be a series of challenges to get you familiar with writing FRC code. You will be creating a Shooter subsystem in both its logic as well as hardware behaviors, while learning how to work with every part of robot coding process (creating constants, writing commands, configuring RobotContainer, etc.).


### Recommened Order Of Completion:
1. [Shooter.java](src/main/java/com/stuypulse/robot/subsystems/Shooter.java)
2. [Settings.java](src/main/java/com/stuypulse/robot/constants/Settings.java)
3. [ShooterImpl.java](src/main/java/com/stuypulse/robot/subsystems/ShooterImpl.java)
4. [ShooterStop.java](src/main/java/com/stuypulse/robot/commands/ShooterStop.java)
5. [ShooterSetRPM.java](src/main/java/com/stuypulse/robot/commands/ShooterSetRPM.java)
6. [ShooterRingShot.java](src/main/java/com/stuypulse/robot/commands/ShooterRingShot.java)
7. [RobotContainer.java](src/main/java/com/stuypulse/robot/RobotContainer.java)


## How To Do This Activity:

0. The activites are setup in a way that some parts are already coded for you in order to help you get started. The parts marked with `// TODO` are the parts that you will be writing yourself. Be sure to read the comments in the code to understand what you need to do. Parts marked with `// XXX` are parts that contain explain to important concepts in code (SHOULD READ THEM). 

### 1: [Shooter.java](src/main/java/com/stuypulse/robot/subsystems/Shooter.java) 
This is the interface that you will be implementing in [ShooterImpl.java](src/main/java/com/stuypulse/robot/subsystems/ShooterImpl.java). This interface contains the logic methods that you will be implementing in ShooterImpl.

### 2. [Settings.java](src/main/java/com/stuypulse/robot/constants/Settings.java) 
This is where you will be creating constants for your shooter. Constants are values that are used throughout your code that you can change in one place. This is useful for tuning your robot and making sure that you don't have to change the same value in multiple places. 

Focus on the Feedback and Feedforward controllers. These are mathematical models that are used to control the shooter's voltage given a desired velocity. VERY IMPORTANT!

### 3. [ShooterImpl.java](src/main/java/com/stuypulse/robot/subsystems/ShooterImpl.java) 
This is where you will be implementing the Shooter interface. Notice where this is where all the hardware logic such as the motors and encoders are created/ used. This is also where you will be implementing the logic methods from the Shooter interface.

### 4. [ShooterStop.java](src/main/java/com/stuypulse/robot/commands/ShooterStop.java)
This command is already made as a guide for the subsequent commands. This command will stop the shooter. Notice how it is extending `InstantCommand` instead of `CommandBase`, as instant commands are commands that are only run once.

### 5. [ShooterSetRPM.java](src/main/java/com/stuypulse/robot/commands/ShooterSetRPM.java)
 This command will set the shooter to a desired RPM. 

### 6. [ShooterRingShot.java](src/main/java/com/stuypulse/robot/commands/ShooterRingShot.java) 
This command will shoot a ring.

### 7. [RobotContainer.java](src/main/java/com/stuypulse/robot/RobotContainer.java)
This is where you will be configuring your robot. This is where you will be creating your subsystems, commands, and button bindings.

## To Use
- Fork this repository to your own GitHub account using the `Fork` button in the top right corner. 
- Clone your forked repository to your computer using `git clone`
- Open the project in VSCode.
- Ensure that the `GradleRIO`, `StuyLib`, and `venderdeps` versions are up-to-date in your new repository.

## To Update | Maintain

- Import project to the latest version of WPILib using the built-in import tool. 
- Check that the `GradleRIO` version is up to date. 
- Check the latest version of [StuyLib here](https://github.com/StuyPulse/StuyLib/releases) and update the version in `./build.gradle`.
- Update the files in `./venderdeps` with their latest version, checking their respective websites. 

## Authors
- [Richie Xue] (https://github.com/Keobkeig)
