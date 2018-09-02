package org.parabot.chino.Theif;

import org.parabot.chino.Theif.data.Settings;
import org.parabot.chino.Theif.strategies.*;
import org.parabot.chino.Theif.ui.UI;
import org.parabot.chino.Theif.utils.Methods;
import org.parabot.chino.Theif.utils.PaintUtils;
import org.parabot.chino.Theif.utils.ScriptTimer;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;
import org.rev317.min.api.methods.Skill;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


@ScriptManifest(
        author = "chino",
        name = "ChinoStaller",
        category = Category.THIEVING,
        version = 1.01,
        description = "Simple Stall Stealer",
        servers = { "OSWAR" })
public class Core extends Script implements ICore, Paintable, MessageListener {
    private final Settings   settings;
    private final Methods    methods;
    private final PaintUtils paintUtils;
    private final UI         ui;

    public Core() {
        this.settings = new Settings();
        this.settings.setStrategies(new ArrayList<Strategy>());
        this.methods = new Methods();
        this.paintUtils = new PaintUtils(this);
        this.ui = new UI(this);
    }

    @Override
    public boolean onExecute() {
        while (this.ui.isVisible()) {
            sleep(200);
        }

        this.settings.setScriptTimer(new ScriptTimer(Skill.THIEVING));

        this.settings.getStrategies().addAll(
                Arrays.asList(
                        new StallSelector(this),
                        //new HandleLogin(),
                        new HandleStealing(this)));
                        //new HandleDropping(this),
                        //new HandleNests(),
                        //new HandleBanking(this)));

        provide(this.settings.getStrategies());
        return true;
    }

    @Override
    public Settings getSettings() {
        return settings;
    }

    @Override
    public Methods getMethods() {
        return methods;
    }

    @Override
    public void paint(Graphics graphics) {
        if (this.ui.isVisible()
                || this.settings.getScriptTimer() == null) {
            return;
        }

        this.paintUtils.paint((Graphics2D) graphics);
    }

    @Override
    public void messageReceived(MessageEvent message) {
        String msg = message.getMessage().toLowerCase();

        if (message.getType() == 0) {
            if (msg.contains("you cut the tree and received")) {
                this.settings.getScriptTimer().increaseLogsChopped();
            } else if (msg.contains("fell out of the tree")) {
                this.settings.getScriptTimer().increaseNestsGained();
            }
        }
    }
}
