package org.parabot.chino.Woodcutter.strategies;

import org.parabot.chino.Woodcutter.data.Variables;
import org.parabot.core.ui.Logger;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Bank;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

public class Banking implements Strategy {
    private SceneObject[] BankBox = SceneObjects.getNearest(3193);

    @Override
    public boolean activate() {
        return !Variables.isPowerChopping() && Inventory.isFull();
    }

    @Override
    public void execute() {
        Logger.addMessage("Banking", true);
       // Variables.setCurrentStatus("Banking");
        if (BankBox !=null && BankBox.length > 0){
            Menu.sendAction(502,1126061225,41,41); // Open bankbox
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Bank.isOpen();
                }
            }, 2500);
            if (Bank.isOpen()) {
                Menu.sendAction(646, 126, 142, 23412); // Deposit button
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Inventory.isEmpty();
                    }
                }, 2500);
                Bank.close();
            }
        }
        if (Bank.getBank().distanceTo() < 20 && Bank.getBank() != null){
            Bank.open();
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Bank.isOpen();
                }
            }, 2500);
            Menu.sendAction(646, 126, 142, 23412); // Deposit button
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Inventory.isEmpty();
                }
            },2500);
            Bank.close();
        }
    }
}