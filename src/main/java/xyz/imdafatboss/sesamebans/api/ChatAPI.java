package xyz.imdafatboss.sesamebans.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.config.ConfigYML;

import java.util.ArrayList;
import java.util.List;

public class ChatAPI {

    Home plugin;
    public ChatAPI(Home instance){

        this.plugin = instance;

    }
    ConfigYML cfg;

    public List<Player> getStaff(){

        cfg = new ConfigYML(plugin);
        List<Player> p = new ArrayList<Player>();

        for(Player o : Bukkit.getOnlinePlayers()){

            if(o.hasPermission(cfg.getStaffPermission())){

                p.add(o);

            }

        }

        return p;

    }

    public void sendStaffMessage(String message, Player p){

        cfg = new ConfigYML(plugin);
        for(Player o : getStaff()){

            String s = cfg.getStaffChat(message, p);
            o.sendMessage(s);

        }

    }

}
