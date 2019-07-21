package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.github.ezauton.core.action.ActionGroup;
import com.github.ezauton.core.action.BackgroundAction;
import com.github.ezauton.core.action.PurePursuitAction;
import com.github.ezauton.core.pathplanning.Path;
import com.github.ezauton.core.pathplanning.purepursuit.PPWaypoint;
import com.github.ezauton.core.pathplanning.purepursuit.PurePursuitMovementStrategy;
import com.github.ezauton.ftc.opmode.ActionBasedOpMode;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;

import java.util.concurrent.TimeUnit;

public class PurePursuitOpMode extends ActionBasedOpMode {


    private Path path;

    @Override
    protected void initEz() {
        // Creates a path with the following coordinates. The y axis represents the forwards direction.
        path = new PPWaypoint.Builder()
                .add(0, 0, 3, 5, -5)
                .add(0, 1, 3, 5, -5)
                .add(1, 1, 3, 5, -5)
                .add(1, 2, 0, 5, -5)
                .buildPathGenerator().generate(0.05);

        telemetry.addData("status", "initialized");
    }

    @Override
    protected void runActions() {
        PurePursuitMovementStrategy ppms = new PurePursuitMovementStrategy(path, 0.1);
        PurePursuitAction purePursuitAction = new PurePursuitAction(10,
                TimeUnit.MILLISECONDS,
                ppms,
                Robot.ROBOT.DRIVE_TRAIN.getLocEst(),
                Constants.LOOKAHEAD,
                Robot.ROBOT.DRIVE_TRAIN.getTrtld());

        Runnable updateTelemetry = new Runnable() {
            @Override
            public void run() {
                telemetry.addData("loc", Robot.ROBOT.DRIVE_TRAIN.getLocEst().estimateLocation());
            }
        };

        Runnable updateDriveTrain = new Runnable() {
            @Override
            public void run() {
                Robot.ROBOT.DRIVE_TRAIN.update();
            }
        };

        BackgroundAction updateLocEst = new BackgroundAction(10, TimeUnit.MILLISECONDS,
                updateTelemetry, updateDriveTrain);

        ActionGroup actionGroup = new ActionGroup()
                .addParallel(updateLocEst)
                .addSequential(purePursuitAction);


        actionScheduler.scheduleAction(actionGroup);
    }

    @Override
    protected void whenFinished() {
        telemetry.addData("status", "finished");
    }
}
