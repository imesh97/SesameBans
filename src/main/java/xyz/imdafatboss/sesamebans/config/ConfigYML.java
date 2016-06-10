package xyz.imdafatboss.sesamebans.config;

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

}
