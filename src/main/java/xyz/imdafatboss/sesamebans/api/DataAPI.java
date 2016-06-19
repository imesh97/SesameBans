package xyz.imdafatboss.sesamebans.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.config.ConfigYML;
import xyz.imdafatboss.sesamebans.config.FileManager;

import java.util.UUID;

public class DataAPI {

    Home plugin;
    public DataAPI(Home instance){

        this.plugin = instance;

    }
    FileManager fm;
    ConfigYML cfg;

    public FileManager.Config getData(){

        fm = new FileManager(plugin);
        return fm.getConfig("data.yml");

    }

    public ConfigurationSection getBan(Player p){

        return getData().get().getConfigurationSection("bans" + p.getUniqueId().toString());

    }

    public ConfigurationSection getBan(UUID uuid){

        return getData().get().getConfigurationSection("bans" + uuid.toString());

    }

}
