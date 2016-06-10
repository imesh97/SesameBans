package xyz.imdafatboss.sesamebans;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.imdafatboss.sesamebans.config.FileManager;

public class Home extends JavaPlugin implements Listener{

    FileManager fm = new FileManager(this);

    @Override
    public void onEnable(){

        fm.getConfig("config.yml").saveDefaultConfig();
        fm.getConfig("messages.yml").saveDefaultConfig();

    }

}
