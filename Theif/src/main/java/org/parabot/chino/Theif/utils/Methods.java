package org.parabot.chino.Theif.utils;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.rev317.min.api.methods.Interfaces;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.wrappers.Item;

import java.text.DecimalFormat;


public class Methods {

    public boolean canAccountUseBank() {
        String s = Interfaces.getInterfaces()[39162].getMessage().toLowerCase();
        return s.contains("super donator")
                || s.contains("extreme donator")
                || s.contains("sponsor");
    }

    public String formatNumber(final double start) {
        final DecimalFormat nf = new DecimalFormat("#.00");
        if (start >= 1000000000) {
            return nf.format(start / 1000000000) + "B";
        } else if (start >= 1000000) {
            return nf.format(start / 1000000) + "M";
        } else if (start >= 1000) {
            return nf.format(start / 1000) + "K";
        }

        return String.valueOf((int) start);
    }

    public void drop(Item item) {
        if (Interfaces.getBackDialogId() != 14170) {
            if (item != null) {
                item.drop();
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Interfaces.getBackDialogId() == 14170;
                    }
                }, 1500);
            }
        } else {
            Menu.clickButton(14175);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Interfaces.getBackDialogId() == -1;
                }
            }, 1500);
        }
    }
}
