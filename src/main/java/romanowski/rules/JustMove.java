package romanowski.rules;

import robocode.HitByBulletEvent;
import robocode.Robot;
import romanowski.model.MoveOrder;

/**
 * Created by krzysiek on 15.09.14.
 */
public class JustMove implements MoveRule {

    boolean intoWall(double distance, double angle, Robot robot) {
        double safeZone = robot.getWidth();
        double x1 = robot.getX() + distance * Math.sin(angle);
        if (x1 < safeZone || x1 > robot.getBattleFieldWidth() + safeZone)
            return true;



        double y1 = robot.getY() + distance * Math.cos(angle);
        return y1 < safeZone || y1 > robot.getBattleFieldHeight() + safeZone;

    }

    @Override
    public MoveOrder match(HitByBulletEvent event, Robot robot) {
        if (!intoWall(10, robot.getHeading(), robot)) {
            return new MoveOrder() {
                @Override
                public void move(Robot robot) {
                    robot.ahead(10);
                }
            };
        }
        return null;
    }

}
