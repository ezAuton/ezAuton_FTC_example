package org.firstinspires.ftc.teamcode;

import com.github.ezauton.core.action.tangible.MainActionScheduler;
import com.github.ezauton.core.utils.RealClock;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.DrivetrainSubsystem;

public class Robot {

    public static Robot ROBOT = null;

    public final MainActionScheduler actionScheduler = new MainActionScheduler(RealClock.CLOCK);
    public final DrivetrainSubsystem DRIVE_TRAIN;


    private Robot(HardwareMap hwMap) {
        DRIVE_TRAIN = new DrivetrainSubsystem(hwMap);
    }

    public static void init(HardwareMap hwMap) { ROBOT = new Robot(hwMap); }
}
