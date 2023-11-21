/************************ PROJECT PHIL ************************/
/* Copyright (c) 2023 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot.constants;

import com.stuypulse.stuylib.network.SmartBoolean;
import com.stuypulse.stuylib.network.SmartNumber;
package com.stuypulse.robot.subsystems.shooter;

import com.stuypulse.stuylib.control.feedback.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;

/*-
 * File containing tunable settings for every subsystem on the robot.
 */
public interface Settings {
    public interface Shooter {    
        //Notice how the constants are grouped together in a single class, all CAPS and static
        //think about how you would use these constants in your methods
        static double MAX_RPM = 5700.0;
        static double MIN_RPM = 100.0;
        static double MAX_RPM_CHANGE = 2000.0;
        static double MAX_RPM_ERROR = 100.0;
    
        public interface ShooterPID {
            double kP = 0.005;
            double kI = 0.0;
            double kD = 0.00033;
    
            static PIDController getController() {
                return new PIDController(ShooterPID.kP, ShooterPID.kI, ShooterPID.kD);
            }
        }
    
        public interface ShooterFF {
            double kS = 0.17118;
            double kV = 0.0020763;
            double kA = 0.00011861;
    
            static SimpleMotorFeedforward getController() {
                return new SimpleMotorFeedforward(ShooterFF.kS, ShooterFF.kV, ShooterFF.kA);
            }
        }
    }
}
