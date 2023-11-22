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
}