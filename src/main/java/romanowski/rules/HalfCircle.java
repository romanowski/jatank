package romanowski.rules;

import robocode.HitByBulletEvent;
import robocode.Robot;
import romanowski.model.MoveOrder;

/**
 * Created by krzysiek on 15.09.14.
 */
public class HalfCircle extends JustMove {
    @Override
    public MoveOrder match(HitByBulletEvent event, Robot robot) {
        if (!intoWall(180 * 1 / Math.PI, 180, robot)) {
            return new MoveOrder() {
                @Override
                public void move(Robot robot) {
                    for (int i = 0; i < 180; i++) {
                        robot.turnLeft(1);
                        robot.ahead(1);
                    }
                }
            };
        }
        return null;
    }
}
