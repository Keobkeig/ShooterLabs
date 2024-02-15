package com.stuypulse.robot.util;

import edu.wpi.first.math.MatBuilder;
import edu.wpi.first.math.Nat;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.system.LinearSystem;
import edu.wpi.first.wpilibj.simulation.LinearSystemSim;

public class VelocitySystem {
    public static LinearSystem<N1, N1, N1> getLinearSystem(double kV, double kA) {
        if (kV < 0)  {
            throw new IllegalArgumentException("Bad kV value.");
        }
        if (kA < 0)  {
            throw new IllegalArgumentException("Bad kA value.");
        }

        return new LinearSystem<N1, N1, N1>(
            MatBuilder.fill(Nat.N1(), Nat.N1(), -kV / kA),
            MatBuilder.fill(Nat.N1(), Nat.N1(), 1/ kA), 
            MatBuilder.fill(Nat.N1(), Nat.N1(), 1),
            MatBuilder.fill(Nat.N1(), Nat.N1(), 0) 
        );
    }

    public static LinearSystemSim<N1, N1, N1> getLinearSystemSim(double kV, double kA) {
        return new LinearSystemSim<>(getLinearSystem(kV, kA));
    }
}
