package com.stuypulse.robot.subsystems;

import javax.print.attribute.standard.MediaSize.NA;

import com.stuypulse.robot.constants.Settings;
import com.stuypulse.robot.util.VelocitySystem;

import edu.wpi.first.math.MatBuilder;
import edu.wpi.first.math.Nat;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.wpilibj.simulation.LinearSystemSim;

public class SimShooter extends Shooter {
    private LinearSystemSim<N1,N1,N1> flywheelSim;

    public SimShooter() {
        super();
        this.flywheelSim = VelocitySystem.getLinearSystemSim(Settings.Shooter.ShooterFF.kV, Settings.Shooter.ShooterFF.kA);
    }

    @Override
    public double getVelocity() {
        return flywheelSim.getOutput(0);
    }

    @Override
    public void periodicallyCalled() {
        flywheelSim.setState(MatBuilder.fill(Nat.N1(),Nat.N1(), getTargetRPM())); 
    }

    @Override
    public void setVoltage(double voltage) {
        flywheelSim.setInput(voltage); 
    }

    @Override
    public double getVoltage() {
        return flywheelSim.getCurrentDrawAmps(); 
    }
}