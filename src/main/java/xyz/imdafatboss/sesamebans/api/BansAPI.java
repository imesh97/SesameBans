package xyz.imdafatboss.sesamebans.api;

import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.config.ConfigYML;
import xyz.imdafatboss.sesamebans.config.FileManager;
import xyz.imdafatboss.sesamebans.utils.Msg;

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



}
