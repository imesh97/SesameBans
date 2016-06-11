package xyz.imdafatboss.sesamebans.cmd.mgt;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.cmd.StaffChatCmd;

import java.util.*;

public class CommandManager implements CommandExecutor {

    Home plugin;
    public CommandManager(Home instance){

        this.plugin = instance;

    }

    private List<CommandFactory> commands = new ArrayList<CommandFactory>();

    public void registerCommand(CommandFactory cmd) {

        commands.add(cmd);

    }

    public void registerCommands(){

        registerCommand(new StaffChatCmd());

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        for (CommandFactory cmds : commands) {

            if (cmds.getName().equalsIgnoreCase(cmd.getName())){

                cmds.execute(sender, args);

            }

        }

        return false;

    }

}