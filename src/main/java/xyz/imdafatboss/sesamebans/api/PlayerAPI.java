package xyz.imdafatboss.sesamebans.api;

import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.config.FileManager;

public class PlayerAPI {

    Home plugin;
    public PlayerAPI(Home instance){

        this.plugin = instance;

    }
    FileManager fm;

    public FileManager.Config getData(){

        fm = new FileManager(plugin);
        return fm.getConfig("data.yml");

    }

    public boolean isBanned(Player p){

        for(String s : getData().get().getConfigurationSection("bans").getKeys(false)){

            if(s.equals(p.getUniqueId().toString())){

                return true;

            }

        }

        return false;

    }

    public boolean isMuted(Player p){

        for(String s : getData().get().getConfigurationSection("mutes").getKeys(false)){

            if(s.equals(p.getUniqueId().toString())){

                return true;

            }

        }

        return false;

    }

    public boolean isIPBanned(Player p){

        for(String s : getData().get().getConfigurationSection("ipbans").getKeys(false)){

            if(s.equals(p.getUniqueId().toString())){

                return true;

            }

        }

        return false;

    }

    public void banPlayer(Player p, int sec, String reason){

        long t = sec * 1000L;
        long time = System.currentTimeMillis() + t;
        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();
        String path = uuid + ".";

        cfg.get().createSection(uuid);
        cfg.get().set(path + "uuid", uuid);
        cfg.get().set(path + "reason", reason);
        cfg.get().set(path + "date", time);

        cfg.save();

    }

}
