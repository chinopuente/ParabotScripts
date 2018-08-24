package org.parabot.chino.Theif.strategies;

import org.parabot.chino.Theif.data.Constants;
import org.parabot.chino.Theif.data.Stall;
import org.parabot.environment.api.utils.Filter;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.methods.Skill;
import org.rev317.min.api.wrappers.SceneObject;



import static org.parabot.chino.Theif.data.Stall.bestStall;



public class Steal implements Strategy {
    private static int tLevel = Skill.getCurrentLevel(int THEIVING);
    private SceneObject[] BestStall = SceneObjects.getNearest(bestStall(tLevel));
    @Override
    public boolean activate() {
        return SceneObjects.getNearest().length > 0
                && Players.getMyPlayer().getAnimation() == -1 && !Inventory.isFull();

    }

    @Override
    public void execute() {
        if (BestStall !=null && BestStall.length > 0){
            BestStall[0].interact(SceneObjects.Option.STEAL_FROM);
        }
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Players.getMyPlayer().getAnimation() == -1;
                }
            }, 600);
        }
    }
}
