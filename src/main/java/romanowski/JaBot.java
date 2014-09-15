package romanowski;

import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import romanowski.crew.Commander;

/**
 * Created by krzysiek on 11.06.14.
 */
public class JaBot extends Robot {

    Commander commander = new Commander(this);

    @Override
    public void run() {
        turnRadarRight(Double.POSITIVE_INFINITY);
        while (true) {
            ahead(5);
            back(5);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        commander.onRobotInSight(event).fire(this);
    }


    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        commander.onBeingHit(event).move(this);
    }
}
