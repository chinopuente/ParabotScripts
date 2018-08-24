package org.parabot.chino.Woodcutter.strategies;

import org.parabot.chino.Woodcutter.data.Constants;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

public class Chop implements Strategy {
    @Override
    public boolean activate() {
        return !Inventory.isFull() && Players.getMyPlayer().getAnimation() == -1;

    }

    @Override
    public void execute() {
        SceneObject[] tree = SceneObjects.getNearest(Constants.MAPLE_TREE_ID);
        if(tree != null && tree.length > 0){
            tree[0].interact(SceneObjects.Option.CHOP_DOWN);
            Menu.clickButton(7487);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Inventory.isFull();
                }
            },4000);
        }
    }
}
