package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.actions.VoltageDriveAuto;

import java.util.concurrent.TimeUnit;

@Autonomous(name="ezAuton example: drive using voltage", group="ezAuton")
@Disabled
public class DriveVoltageOpmode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Robot.init(hardwareMap);

        Robot.ROBOT.actionScheduler.scheduleAction(new VoltageDriveAuto(10, TimeUnit.SECONDS, 0.5, 0.5));

    }
}
