package xyz.imdafatboss.sesamebans.config;

import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.utils.Msg;

public class MessagesYML {

    Home plugin;
    public MessagesYML(Home instance){

        this.plugin = instance;

    }
    FileManager fm;
    ConfigYML cfg;

    public FileManager.Config getConfig(){

        fm = new FileManager(plugin);
        return fm.getConfig("messages.yml");

    }

    public String prefix(){

        cfg = new ConfigYML(plugin);
        return cfg.prefix();

    }

    public String getNoPerm(){

        return getConfig().get().getString("no-permission");

    }

    public String getPlayerOnlyCmd(){

        return getConfig().get().getString("player-only-cmd");

    }

    public String getUsageSc(){

        return Msg.translate(getConfig().get().getString("usage.staffchat"));

    }

    public String getUsageBan(){

        return Msg.translate(getConfig().get().getString("usage.ban"));

    }

    public String getPlayerNotExist() {

        return Msg.translate(getConfig().get().getString("player-not-exist"));

    }

    public String getAlreadyBanned(){

        return Msg.translate(getConfig().get().getString("already.banned"));

    }

    public String getAlreadyMuted(){

        return Msg.translate(getConfig().get().getString("already.muted"));

    }

    public String getNotBanned(){

        return Msg.translate(getConfig().get().getString("not.banned"));

    }

    public String getNotMuted(){

        return Msg.translate(getConfig().get().getString("not.muted"));

    }

    public String getBanBroadcast(){

        return Msg.translate(getConfig().get().getString("broadcast.ban"));

    }

    public String getUsageUnban(){

        return Msg.translate(getConfig().get().getString("usage.unban"));

    }

    public String getUnbanBroadcast(){

        return Msg.translate(getConfig().get().getString("broadcast.unban"));

    }

    public String getUsageMute(){

        return Msg.translate(getConfig().get().getString("usage.mute"));

    }

    public String getMuteBroadcast(){

        return Msg.translate(getConfig().get().getString("broadcast.mute"));

    }

    public String getUsageUnmute(){

        return Msg.translate(getConfig().get().getString("usage.unmute"));

    }

    public String getUnmuteBroadcast(){

        return Msg.translate(getConfig().get().getString("broadcast.unmute"));

    }

}
