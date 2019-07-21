package org.firstinspires.ftc.teamcode.subsystems;

import com.github.ezauton.core.action.require.BaseResource;
import com.github.ezauton.core.actuators.TypicalMotor;
import com.github.ezauton.core.localization.TranslationalLocationEstimator;
import com.github.ezauton.core.localization.Updateable;
import com.github.ezauton.core.localization.estimators.TankRobotEncoderEncoderEstimator;
import com.github.ezauton.core.robot.TankRobotConstants;
import com.github.ezauton.core.robot.implemented.TankRobotTransLocDriveable;
import com.github.ezauton.ftc.utility.MotorControllers;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.RobotMap;


/**
 * A FRC-style, FTC-compatible definition of a subsystem.
 *
 * By segmenting motors under different BaseResources, we are easily able to prevent
 * multiple actions from running the same motors simultaneously. This reduces the potential for
 * code-induced mechanical damage to the robot.
 *
 * Resources can be required and taken by actions. Actions that need to take a resource block until it
 * becomes available.
 */
public class DrivetrainSubsystem extends BaseResource implements Updateable {

    private final DcMotorEx leftFront;
    private final DcMotorEx rightFront;

    private final DcMotorEx leftBack;
    private final DcMotorEx rightBack;

    private final TypicalMotor left;
    private final TypicalMotor right;

    private final TankRobotEncoderEncoderEstimator locEst;

    private final TankRobotTransLocDriveable trtld;

    private final TankRobotConstants constants = new TankRobotConstants() {
        @Override
        public double getLateralWheelDistance() {
            return Constants.WHEELBASE_WIDTH_FEET;
        }
    };

    public DrivetrainSubsystem(HardwareMap hwMap) {
        leftFront = (DcMotorEx) hwMap.get(RobotMap.Motors.DT_LEFT_FRONT);
        rightFront = (DcMotorEx) hwMap.get(RobotMap.Motors.DT_RIGHT_FRONT);
        leftBack = (DcMotorEx) hwMap.get(RobotMap.Motors.DT_LEFT_BACK);
        rightBack = (DcMotorEx) hwMap.get(RobotMap.Motors.DT_RIGHT_BACK);

        left = MotorControllers.fromDcMotorEx(Constants.TICKS_PER_FOOT, leftFront, leftBack);
        right = MotorControllers.fromDcMotorEx(Constants.TICKS_PER_FOOT, rightFront, leftBack);

        locEst = new TankRobotEncoderEncoderEstimator(left, right, constants);

        trtld = new TankRobotTransLocDriveable(left, right, locEst, locEst, constants);
    }


    public void driveVoltage(double leftVoltage, double rightVoltage) {
        left.runVoltage(leftVoltage);
        right.runVoltage(rightVoltage);
    }

    public TankRobotEncoderEncoderEstimator getLocEst() {
        return locEst;
    }

    public TankRobotTransLocDriveable getTrtld() {
        return trtld;
    }

    @Override
    public boolean update() {
        locEst.update();
        return true;
    }
}
