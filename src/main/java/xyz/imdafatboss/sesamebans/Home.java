package xyz.imdafatboss.sesamebans;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandManager;
import xyz.imdafatboss.sesamebans.config.FileManager;
import xyz.imdafatboss.sesamebans.events.BanEvents;

import java.util.Arrays;

public class Home extends JavaPlugin implements Listener{

    FileManager fm = new FileManager(this);
    CommandManager cmd;

    @Override
    public void onEnable(){

        // Save default config files
        fm.getConfig("config.yml").saveDefaultConfig();
        fm.getConfig("messages.yml").saveDefaultConfig();
        fm.getConfig("data.yml").saveDefaultConfig();

        // Initialize
        cmd = new CommandManager(this);
        PluginManager pm = Bukkit.getServer().getPluginManager();

        // Manage all commands.
        cmd.registerCommands(this);
        getCommand("staffchat").setExecutor(cmd);
        getCommand("ban").setExecutor(cmd);
        getCommand("unban").setExecutor(cmd);

        String[] scAliases = {"sc", "schat", "staffc"};
        getCommand("staffchat").setAliases(Arrays.asList(scAliases));
        getCommand("staffchat").setDescription("Communicate with the other staff on the server");

        String[] banAliases = {"banplayer", "banp"};
        getCommand("ban").setAliases(Arrays.asList(banAliases));
        getCommand("ban").setDescription("Ban a player");

        String[] unbanAliases = {"unbanplayer", "unbanp"};
        getCommand("unban").setAliases(Arrays.asList(unbanAliases));
        getCommand("unban").setDescription("Unban a player");

        // Events
        pm.registerEvents(new BanEvents(this), this);

    }

}
