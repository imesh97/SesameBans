package xyz.imdafatboss.sesamebans.api;

import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.config.ConfigYML;
import xyz.imdafatboss.sesamebans.config.FileManager;

public class BansAPI {

    Home plugin;
    public BansAPI(Home instance){

        this.plugin = instance;

    }
    FileManager fm;
    ConfigYML cfg;

    public FileManager.Config getData(){

        fm = new FileManager(plugin);
        return fm.getConfig("data.yml");

    }

    public void kickPlayer(Player p, String reason){

        

    }

    public void kickPlayer(Player p){

        cfg = new ConfigYML(plugin);
        String s = cfg.prefix() + cfg.getDefaultKick();

        p.kickPlayer(s);

    }

}
