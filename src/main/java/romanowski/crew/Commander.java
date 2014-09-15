package romanowski.crew;

import robocode.HitByBulletEvent;
import robocode.ScannedRobotEvent;
import romanowski.JaBot;
import romanowski.model.FireOrder;
import romanowski.model.HoldFire;
import romanowski.model.MoveOrder;
import romanowski.model.Stay;
import romanowski.rules.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzysiek on 11.06.14.
 */
public class Commander {

    JaBot robot;
    List<MoveRule> moveRules = new ArrayList<MoveRule>();
    List<FireRule> fireRules = new ArrayList<FireRule>();


    public Commander(JaBot robot) {
        this.robot = robot;

        fireRules.add(new CloseFire());
        fireRules.add(new FarFireAhead());
        fireRules.add(new FarFireBelow());
        fireRules.add(new FarFireFarBelow());
        fireRules.add(new FarFireFarAhead());

        moveRules.add(new JustMove());
        moveRules.add(new RotateAndRun());
        moveRules.add(new HalfCircle());


    }

    public FireOrder onRobotInSight(ScannedRobotEvent event) {
        java.util.Collections.shuffle(fireRules);
        for (FireRule rule : fireRules) {
            FireOrder order = rule.match(event, robot);
            if (order != null) {
                return order;
            }
        }
        return new HoldFire();
    }


    public MoveOrder onBeingHit(HitByBulletEvent event) {
        java.util.Collections.shuffle(moveRules);
        for (MoveRule rule : moveRules) {
            MoveOrder order = rule.match(event, robot);
            if (order != null) {
                return order;
            }
        }
        return new Stay();
    }

}
