package org.parabot.chino.Theif.strategies;

import org.parabot.chino.Theif.ICore;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;


public class HandleStealing implements org.parabot.environment.scripts.framework.Strategy {
    private final ICore core;

    public HandleStealing(ICore core) {
        this.core = core;
    }

    @Override
    public boolean activate() {
        return Players.getMyPlayer().getAnimation() == -1
                && !Inventory.isFull();
    }

    @Override
    public void execute() {
        try {
            SceneObject[] objects = SceneObjects.getNearest(this.core.getSettings().getStall().getId());

            if (objects != null && objects.length > 0) {
                objects[0].interact(SceneObjects.Option.STEAL_FROM);
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Players.getMyPlayer().getAnimation() != -1;
                    }
                }, 5000);
            }
        } catch (Exception ignored) {
        }
    }
}
