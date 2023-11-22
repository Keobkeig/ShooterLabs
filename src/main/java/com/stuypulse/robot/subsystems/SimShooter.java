package com.stuypulse.robot.subsystems;

public class SimShooter extends Shooter {
    private double velocity;

    public SimShooter() {
        super();
        this.velocity = 0.0;
    }

    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public void periodicallyCalled() {
        velocity = getTargetRPM();
    }

    @Override
    public void setVoltage(double voltage) {
        return;
    }

    @Override
    public double getVoltage() {
        return 0.0;
    }
}