package org.parabot.chino.Woodcutter.main;

import org.parabot.chino.Woodcutter.data.Variables;
import org.parabot.chino.Woodcutter.strategies.Banking;
import org.parabot.chino.Woodcutter.strategies.Chop;
import org.parabot.chino.Woodcutter.strategies.Drop;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Timer;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;

import java.awt.*;
import java.util.ArrayList;


@ScriptManifest(author = "Chino", category = Category.WOODCUTTING, description = "Simple woodcutter", name = "Woodcutter", version = 1.0, servers = ("Dreamscape"))
public class Core extends Script implements Paintable, MessageListener {
    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    private Timer time = new Timer();
    private final Font font1 = new Font("Copperplate Gothic Bold",Font.BOLD,20);
    private final Color color1 = new Color(0xDAEAD9);
    private static int treesCut = 0;
    @Override
    public boolean onExecute(){
        Variables.setPowerChopping(true);

        strategies.add(new Chop());
        strategies.add(new Drop());
        strategies.add(new Banking());
        System.out.println("Power chopping is:" + Variables.isPowerChopping());
        provide(strategies);
        return true;
    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setFont(font1);
        g.setColor(color1);
        g.drawString("Time: " + time,8,325);
        g.drawString("Logs Cut: " + treesCut,8,300);
        //g.drawString("Logs per Hour:" + treesCut / time *60*60,8,350);
    }

    @Override
    public void messageReceived(MessageEvent m) {
        String msg = m.getMessage();
        if(m.getType() == 0){
            //System.out.println(msg);
            if (msg.contains("You cut the tree and received some ")){
                //System.out.println("checking messages");
                treesCut++;
            }
        }
    }
}
