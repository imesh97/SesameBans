package xyz.imdafatboss.sesamebans;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandManager;
import xyz.imdafatboss.sesamebans.config.FileManager;
import xyz.imdafatboss.sesamebans.events.BanEvents;
import xyz.imdafatboss.sesamebans.events.MuteEvents;

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
        getCommand("mute").setExecutor(cmd);
        getCommand("unmute").setExecutor(cmd);
        getCommand("kick").setExecutor(cmd);

        String[] scAliases = {"sc", "schat", "staffc"};
        getCommand("staffchat").setAliases(Arrays.asList(scAliases));
        getCommand("staffchat").setDescription("Communicate with the other staff on the server");

        String[] banAliases = {"banplayer", "banp"};
        getCommand("ban").setAliases(Arrays.asList(banAliases));
        getCommand("ban").setDescription("Ban a player");

        String[] unbanAliases = {"unbanplayer", "unbanp", "uban"};
        getCommand("unban").setAliases(Arrays.asList(unbanAliases));
        getCommand("unban").setDescription("Unban a player");

        String[] muteAliases = {"mutep", "muteplayer"};
        getCommand("mute").setAliases(Arrays.asList(muteAliases));
        getCommand("mute").setDescription("Mute a player");

        String[] unmuteAliases = {"unmutep", "unmuteplayer", "umute"};
        getCommand("unmute").setAliases(Arrays.asList(unmuteAliases));
        getCommand("unmute").setDescription("Unmute a player");

        String[] kickAliases = {"kickp", "kickplayer"};
        getCommand("kick").setAliases(Arrays.asList(kickAliases));
        getCommand("kick").setDescription("Kick a player");

        // Events
        pm.registerEvents(new BanEvents(this), this);
        pm.registerEvents(new MuteEvents(this), this);

    }

}
