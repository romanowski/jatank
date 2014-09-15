package romanowski.rules;

import robocode.Robot;
import robocode.ScannedRobotEvent;
import romanowski.model.FireOrder;

/**
 * Created by krzysiek on 15.09.14.
 */
public interface FireRule {
    public FireOrder match(ScannedRobotEvent event, Robot robot);
}
