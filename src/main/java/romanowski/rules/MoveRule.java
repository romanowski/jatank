package romanowski.rules;

import robocode.HitByBulletEvent;
import robocode.Robot;
import romanowski.model.MoveOrder;

/**
 * Created by krzysiek on 15.09.14.
 */
public interface MoveRule {
    public MoveOrder match(HitByBulletEvent event, Robot robot);
}
