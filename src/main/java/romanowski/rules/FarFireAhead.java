package romanowski.rules;

import robocode.ScannedRobotEvent;

/**
 * Created by krzysiek on 15.09.14.
 */
public class FarFireAhead extends FarFireBelow {

    @Override
    double gunRotation(ScannedRobotEvent event, double angle) {
        return super.gunRotation(event, angle) + 8;
    }
}
