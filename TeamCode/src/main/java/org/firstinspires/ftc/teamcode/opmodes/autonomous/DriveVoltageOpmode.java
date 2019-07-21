package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.github.ezauton.ftc.opmode.ActionBasedOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.actions.VoltageDriveAuto;

import java.util.concurrent.TimeUnit;

@Autonomous(name="ezAuton example: drive using voltage", group="ezAuton")
@Disabled
public class DriveVoltageOpmode extends ActionBasedOpMode {

    @Override
    protected void initEz() {
        Robot.init(hardwareMap);

        telemetry.addData("status", "initialized");
    }

    @Override
    protected void runActions() {
        actionScheduler.scheduleAction(new VoltageDriveAuto(10, TimeUnit.SECONDS, 1, 1));
    }

    @Override
    protected void whenFinished() {
        telemetry.addData("status", "complete");
    }

}
