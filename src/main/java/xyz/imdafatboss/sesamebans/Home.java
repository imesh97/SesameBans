package xyz.imdafatboss.sesamebans;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandManager;
import xyz.imdafatboss.sesamebans.config.FileManager;

public class Home extends JavaPlugin implements Listener{

    FileManager fm = new FileManager(this);
    CommandManager cmd;

    @Override
    public void onEnable(){

        cmd = new CommandManager(this);

        fm.getConfig("config.yml").saveDefaultConfig();
        fm.getConfig("messages.yml").saveDefaultConfig();

        cmd.registerCommands(this);

    }

}
