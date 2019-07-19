package org.firstinspires.ftc.teamcode.subsystems;

import com.github.ezauton.core.action.require.BaseResource;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

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
public class DrivetrainSubsystem extends BaseResource {

    private final DcMotor leftFront;
    private final DcMotor rightFront;

    private final DcMotor leftBack;
    private final DcMotor rightBack;


    public DrivetrainSubsystem(HardwareMap hwMap) {
        leftFront = (DcMotor) hwMap.get(RobotMap.Motors.DT_LEFT_FRONT);
        rightFront = (DcMotor) hwMap.get(RobotMap.Motors.DT_RIGHT_FRONT);
        leftBack = (DcMotor) hwMap.get(RobotMap.Motors.DT_LEFT_BACK);
        rightBack = (DcMotor) hwMap.get(RobotMap.Motors.DT_RIGHT_BACK);
    }


    public void driveVoltage(double leftVoltage, double rightVoltage) {
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftFront.setPower(leftVoltage);
        leftBack.setPower(leftVoltage);

        rightFront.setPower(rightVoltage);
        rightBack.setPower(rightVoltage);
    }
}
