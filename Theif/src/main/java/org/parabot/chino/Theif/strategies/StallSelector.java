package org.parabot.chino.Theif.strategies;

import org.parabot.chino.Theif.ICore;
import org.parabot.chino.Theif.data.Stall;


public class StallSelector implements org.parabot.environment.scripts.framework.Strategy {
    private final ICore core;
    private       int   knownLevel;

    public StallSelector(ICore core) {
        this.core = core;
    }

    @Override
    public boolean activate() {
        return knownLevel != this.core.getSettings().getScriptTimer().getSkill().getRealLevel()
                && this.core.getSettings().isAutoProgress();
    }

    @Override
    public void execute() {
        this.knownLevel = this.core.getSettings().getScriptTimer().getSkill().getRealLevel();
        this.core.getSettings().setStall(Stall.getFittingForLevel(knownLevel));
    }
}
