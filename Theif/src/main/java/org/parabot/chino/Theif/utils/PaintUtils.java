package org.parabot.chino.Theif.utils;

import org.parabot.chino.Theif.ICore;

import java.awt.*;

public class PaintUtils {
    private final ICore core;

    public PaintUtils(ICore core) {
        this.core = core;
    }

    public void paint(Graphics2D g2) {
        g2.setColor(Color.green);
        g2.drawString("Chino's Staller", 10, 35);
        g2.drawString("Runtime: " + this.core.getSettings().getScriptTimer(), 10, 65);
        g2.drawString("XP Gained (/h): "
                + this.core.getMethods().formatNumber(this.core.getSettings().getScriptTimer().getXpGained())
                + " ("
                + this.core.getMethods().formatNumber(
                this.core.getSettings().getScriptTimer().getPerHour(
                        this.core.getSettings().getScriptTimer().getXpGained()))
                + ")", 10, 80);
        g2.drawString("Current level: "
                + this.core.getSettings().getScriptTimer().getSkill().getLevel()
                + " (+"
                + this.core.getSettings().getScriptTimer().levelsGained() + ")", 10, 95);
        g2.drawString("Logs chopped (/h): "
                + this.core.getMethods().formatNumber(this.core.getSettings().getScriptTimer().getLogsChopped())
                + " ("
                + this.core.getMethods().formatNumber(this.core.getSettings().getScriptTimer().getPerHour(
                this.core.getSettings().getScriptTimer().getLogsChopped()))
                + ")", 10, 110);
        g2.drawString("Nests gained (/h): "
                + this.core.getMethods().formatNumber(this.core.getSettings().getScriptTimer().getNestsGained())
                + " ("
                + this.core.getMethods().formatNumber(this.core.getSettings().getScriptTimer().getPerHour(
                this.core.getSettings().getScriptTimer().getNestsGained()))
                + ")", 10, 125);
        g2.drawString("Current Stall: "
                + this.core.getSettings().getStall().toString(), 10, 140);
    }
}
