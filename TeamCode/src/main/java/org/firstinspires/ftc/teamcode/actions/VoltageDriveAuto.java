package org.firstinspires.ftc.teamcode.actions;

import com.github.ezauton.core.action.TimedPeriodicAction;

import org.firstinspires.ftc.teamcode.Robot;

import java.util.concurrent.TimeUnit;

public class VoltageDriveAuto extends TimedPeriodicAction {
    private final double leftVolts;
    private final double rightVolts;

    public VoltageDriveAuto(long duration, TimeUnit durationUnit, double leftVolts, double rightVolts) {
        super(duration, durationUnit);
        this.leftVolts = leftVolts;
        this.rightVolts = rightVolts;
    }

    @Override
    protected void init() throws Exception {
        Robot.ROBOT.DRIVE_TRAIN.take();
    }

    @Override
    protected void execute() throws Exception {
        Robot.ROBOT.DRIVE_TRAIN.driveVoltage(leftVolts, rightVolts);
    }

    @Override
    public void end() throws Exception {
        Robot.ROBOT.DRIVE_TRAIN.giveBack();
    }
}
