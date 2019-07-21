package org.firstinspires.ftc.teamcode;

import com.github.ezauton.core.localization.TranslationalLocationEstimator;
import com.github.ezauton.core.pathplanning.purepursuit.LookaheadBounds;

/**
 * A class to store handy constants (e.g robot measurements, field measurements)
 *
 * Although this is not included in the default WPILib project generation, it is quite handy in
 * terms of reducing the amount of magic numbers found in the code
 */
public class Constants {

    public static final double WHEELBASE_WIDTH_INCHES = 12D;

    public static final double WHEELBASE_WIDTH_FEET = WHEELBASE_WIDTH_INCHES / 12;
    public static final int TICKS_PER_FOOT = 4096;
    public static final LookaheadBounds LOOKAHEAD = new LookaheadBounds(1 / 6D, 1D, 3, 8, Robot.ROBOT.DRIVE_TRAIN.getLocEst());
}
