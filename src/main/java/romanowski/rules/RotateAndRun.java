package romanowski.rules;

import robocode.HitByBulletEvent;
import robocode.Robot;
import romanowski.model.MoveOrder;

/**
 * Created by krzysiek on 15.09.14.
 */
public class RotateAndRun extends JustMove {
    @Override
    public MoveOrder match(HitByBulletEvent event, Robot robot) {
        if (!intoWall(20, 30, robot)) {
            return new MoveOrder() {
                @Override
                public void move(Robot robot) {
                    robot.turnLeft(20);
                    robot.ahead(30);
                }
            };
        }
        return null;
    }

}
