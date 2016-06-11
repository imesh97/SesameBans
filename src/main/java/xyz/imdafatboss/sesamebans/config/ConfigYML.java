package xyz.imdafatboss.sesamebans.config;

import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.utils.Msg;

public class ConfigYML {

    Home plugin;
    public ConfigYML(Home instance){

        this.plugin = instance;

    }
    FileManager fm;

    public FileManager.Config getConfig(){

        fm = new FileManager(plugin);
        return fm.getConfig("config.yml");

    }

    public String getPrefix(){

        return Msg.translate(getConfig().get().getString("prefix"));

    }

    public String prefix(){

        return getPrefix() + " ";

    }

    public String getDefaultKick(){

        return Msg.translate(getConfig().get().getString("default.kick"));

    }

    public String getStaffChatFormat(){

        return getConfig().get().getString("sc-format");

    }

    public String getStaffChat(String message, Player p){

        String s = getStaffChatFormat();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%message%", message);

        return Msg.translate(s2);

    }

}
