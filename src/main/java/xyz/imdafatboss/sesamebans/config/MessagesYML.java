package xyz.imdafatboss.sesamebans.config;

import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.utils.Msg;

public class MessagesYML {

    Home plugin;
    public MessagesYML(Home instance){

        this.plugin = instance;

    }
    FileManager fm;

    public FileManager.Config getConfig(){

        fm = new FileManager(plugin);
        return fm.getConfig("messages.yml");

    }

    public String getUsageSc(){

        return Msg.translate(getConfig().get().getString("usage.staffchat"));

    }

}
