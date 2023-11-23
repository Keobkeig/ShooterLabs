/************************ PROJECT PHIL ************************/
/* Copyright (c) 2023 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot.constants;

// import com.stuypulse.stuylib.network.SmartBoolean;
// import com.stuypulse.stuylib.network.SmartNumber;

import com.stuypulse.stuylib.control.feedback.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;

/*-
 * File containing tunable settings for every subsystem on the robot.
 */
public interface Settings {
    public interface Shooter {    
        //Notice how the constants are grouped together in a single class
        //Constant variable names should all CAPS and static
        //think about how you would use these constants in your methods

        /*TODO: Make the following constants: 
         * MAX_RPM of type double and set it to 5700.0
         * MIN_RPM of type double and set it to 100.0
         * MAX_RPM_CHANGE of type double and set it to 2000.0
         * MAX_RPM_ERROR of type double and set it to 100.0
         * RING_RPM of type double and set it to 4000.0
         * 
         * e.g.
         * public static final double MAX_RPM = 5700.0;
        */
     
        public interface ShooterPID {
            double kP = 0.005;
            double kI = 0.0;
            double kD = 0.00033;
            
            // This is a static method, you can call it like this: Settings.Shooter.ShooterPID.getController()
            // This is useful because you can use it to initialize your PIDController in your constructor
            // Use this one for feedback
            static PIDController getController() {
                return new PIDController(ShooterPID.kP, ShooterPID.kI, ShooterPID.kD);
            }
        }
    
        public interface ShooterFF {
            //TODO: Make the following constants:
            //kS of type double and set it to 0.17118
            //kV of type double and set it to 0.0020763
            //kA of type double and set it to 0.00011861
            //e.g.
            //public static final double kS = 0.17118;
            
            //TODO: Make a static method called getController() that returns a SimpleMotorFeedforward
            //Use the constants you made above to initialize the SimpleMotorFeedforward (look at the constructor for ShooterPID's getController method on line 42)
            
        }
    }
}
