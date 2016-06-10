package xyz.imdafatboss.sesamebans.api;

import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.config.FileManager;

public class BansAPI {

    Home plugin;
    public BansAPI(Home instance){

        this.plugin = instance;

    }
    FileManager fm;

    public FileManager.Config getData(){

        fm = new FileManager(plugin);
        return fm.getConfig("data.yml");

    }

    public FileManager.Config mainConfig(){

        fm = new FileManager(plugin);
        return fm.getConfig("config.yml");

    }

    public void kickPlayer(Player p, String reason){

        

    }

}
