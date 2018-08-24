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
import org.rev317.min.api.wrappers.SceneObject;

import static org.parabot.chino.Theif.data.Stall.CRAFTING;
import static org.parabot.chino.Theif.main.Core.wcLevel;

public class Steal implements Strategy {
    @Override
    public boolean activate() {
        return Players.getMyPlayer().getAnimation() == -1 && !Inventory.isFull();

    }

    @Override
    public void execute() {
        SceneObject[] objects = SceneObjects.getNearest(new Filter<SceneObject>() {
            @Override
            public boolean accept(SceneObject sceneObject) {
                return sceneObject.getId() == Stall.bestStall();
            }
        });
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Players.getMyPlayer().getAnimation() == -1;
                }
            }, 2600);
        }
    }
}
