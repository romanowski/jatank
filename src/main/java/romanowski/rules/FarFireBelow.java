package romanowski.rules;

import robocode.ScannedRobotEvent;

/**
 * Created by krzysiek on 15.09.14.
 */
public class FarFireBelow extends CloseFire {
    public FarFireBelow() {
    }

    @Override
    boolean isTooFar(ScannedRobotEvent event) {
        return 100 > event.getDistance();
    }

    @Override
    boolean isTooFast(ScannedRobotEvent event) {
        return 1 > Math.abs(event.getVelocity());
    }

    @Override
    double gunRotation(ScannedRobotEvent event, double angle) {
        return super.gunRotation(event, angle) - 8;
    }
}
