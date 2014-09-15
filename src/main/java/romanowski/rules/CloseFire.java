package romanowski.rules;

import robocode.Robot;
import robocode.Rules;
import robocode.ScannedRobotEvent;
import romanowski.model.FireOrder;

public class CloseFire implements FireRule {

    double power = Rules.MAX_BULLET_POWER;
    double maxDistance = 100;
    double maxVelocity = 6;


    boolean isTooFar(ScannedRobotEvent event) {
        return event.getDistance() > maxDistance;
    }

    boolean isTooFast(ScannedRobotEvent event) {
        return event.getVelocity() > maxVelocity;
    }

    double gunRotation(ScannedRobotEvent event, double angle) {
        return angle;
    }

    @Override
    public FireOrder match(ScannedRobotEvent event, Robot robot) {
        double angle = robot.getHeading() - robot.getGunHeading() + event.getBearing();
        if (angle > 180) angle = angle - 360;
        if(angle < -180) angle = angle + 360;

        if (!isTooFar(event) && !isTooFast(event)) {
            final double gunRotation = gunRotation(event, angle);
            return new FireOrder() {
                @Override
                public void fire(Robot robot) {
                    robot.turnGunRight(gunRotation);
                    robot.fire(power);
                }
            };
        }

        return null;
    }
}
