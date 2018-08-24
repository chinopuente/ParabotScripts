package org.parabot.chino.Woodcutter.strategies;

import org.parabot.chino.Woodcutter.data.Constants;
import org.parabot.chino.Woodcutter.data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Interfaces;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.wrappers.Item;

public class Drop implements Strategy {
    @Override
    public boolean activate() {
        return Inventory.isFull() && Variables.isPowerChopping();
    }

    @Override
    public void execute() {
        for (Item i : Inventory.getItems(Constants.LOGS_ID)) {
            if (i != null) {
                i.drop();
                Time.sleep(600);
                if(Interfaces.getBackDialogId() == Constants.DROP_INTERFACE){
                    Menu.clickButton(Constants.YES_BUTTON_ID);
                    //System.out.println("Clicked Button");
                    Time.sleep(600);
                }

				/*
                Check the interface
                Use a menu send action to click yes
				*/
            }
            Time.sleep(600);
        }

    }
}
