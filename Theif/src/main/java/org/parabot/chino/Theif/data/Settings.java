package org.parabot.chino.Theif.data;

import org.parabot.chino.Theif.data.Stall;
import org.parabot.chino.Theif.utils.ScriptTimer;
import org.parabot.environment.scripts.framework.Strategy;

import java.util.ArrayList;


public class Settings {

    private ArrayList<Strategy> strategies;
    private Stall stall;
    private ScriptTimer         scriptTimer;
    private boolean             autoProgress;
    private boolean             powerLevel;

    public ArrayList<Strategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(ArrayList<Strategy> strategies) {
        this.strategies = strategies;
    }

    public Stall getStall() {
        return stall;
    }

    public void setStall(Stall stall) {
        this.stall = stall;
    }

    public ScriptTimer getScriptTimer() {
        return scriptTimer;
    }

    public void setScriptTimer(ScriptTimer scriptTimer) {
        this.scriptTimer = scriptTimer;
    }

    public boolean isAutoProgress() {
        return autoProgress;
    }

    public void setAutoProgress(boolean autoProgress) {
        this.autoProgress = autoProgress;
    }

    public boolean isPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(boolean powerLevel) {
        this.powerLevel = powerLevel;
    }
}
