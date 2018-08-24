package org.parabot.chino.Theif.main;

import org.parabot.chino.Theif.strategies.Steal;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Timer;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;
import org.rev317.min.api.methods.Skill;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
@ScriptManifest(author = "Chino", category = Category.THIEVING, description = "Simple Stall stealing", name = "Thieve", version = 1.0, servers = ("Dreamscape"))
public class Core extends Script implements Paintable, MessageListener {
    public static int tLevel = Skill.getCurrentLevel(int THEIVING)
    DecimalFormat df = new DecimalFormat("0.000");
    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    private final Font font1 = new Font("Copperplate Gothic Bold",Font.BOLD,20);
    private final Color color1 = new Color(0x030091);
    private static int ticketsTaken = 0;
    private Timer time = new Timer();
    @Override
    public boolean onExecute() {
        strategies.add(new Steal());
        provide(strategies);
        return true;
    }
    @Override
    public void onFinish() {
        super.onFinish();

    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setFont(font1);
        g.setColor(color1);
        g.drawString("Time Running: " + time,270,400);
        g.drawString("Trillions Stolen: " + (df.format(ticketsTaken*0.001)),260,420);
    }

    @Override
    public void messageReceived(MessageEvent m) {
        String msg = m.getMessage();
        if(m.getType() == 0){
            //System.out.println(msg);
            if (msg.contains("You stole a 1bil check")){
                //System.out.println("checking messages");
                ticketsTaken++;
                ticketsTaken++;
            }
        }
    }
}
