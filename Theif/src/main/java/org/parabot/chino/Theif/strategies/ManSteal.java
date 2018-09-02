package org.parabot.chino.Theif.strategies;

import org.parabot.chino.Theif.ICore;
import org.parabot.environment.scripts.framework.Strategy;

public class ManSteal implements Strategy {
    private final ICore core;

    public ManSteal(ICore core) {
        this.core = core;
    }
    @Override
    public boolean activate() {
        return false;
    }

    @Override
    public void execute() {

    }
}
