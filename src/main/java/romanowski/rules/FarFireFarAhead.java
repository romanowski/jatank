package romanowski.rules;

import robocode.ScannedRobotEvent;

/**
 * Created by krzysiek on 15.09.14.
 */
public class FarFireFarAhead extends FarFireBelow {

    @Override
    double gunRotation(ScannedRobotEvent event, double angle) {
        return super.gunRotation(event, angle) + 15;
    }
}
