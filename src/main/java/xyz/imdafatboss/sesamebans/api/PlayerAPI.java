package xyz.imdafatboss.sesamebans.api;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.config.ConfigYML;
import xyz.imdafatboss.sesamebans.config.FileManager;
import xyz.imdafatboss.sesamebans.config.MessagesYML;
import xyz.imdafatboss.sesamebans.utils.Msg;

import java.util.List;
import java.util.UUID;

public class PlayerAPI {

    Home plugin;
    public PlayerAPI(Home instance){

        this.plugin = instance;

    }
    FileManager fm;
    ConfigYML cfg;
    MessagesYML msg;
    DataAPI data;

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

    public boolean isBanned(OfflinePlayer p){

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

    public boolean isMuted(OfflinePlayer p){

        for(String s : getData().get().getConfigurationSection("mutes").getKeys(false)){

            if(s.equals(p.getUniqueId().toString())){

                return true;

            }

        }

        return false;

    }

    public boolean isIPBanned(String ip){

        for(String s : getData().get().getStringList("ipbans")){

            if(s.equals(ip)){

                return true;

            }

        }

        return false;

    }

    public boolean isTempbanned(Player p){

        data = new DataAPI(plugin);
        for(String s : getData().get().getConfigurationSection("tempbans").getKeys(false)){

            if(s.equals(p.getUniqueId().toString())){

                long time = data.getTempban(p).getLong("date");
                if(System.currentTimeMillis() < time){

                    return true;

                }
                return false;

            }

        }

        return false;

    }

    public boolean isTempmuted(Player p){

        data = new DataAPI(plugin);
        for(String s : getData().get().getConfigurationSection("tempmutes").getKeys(false)){

            if(s.equals(p.getUniqueId().toString())){

                long time = data.getTempmute(p).getLong("date");
                if(System.currentTimeMillis() < time){

                    return true;

                }
                return false;

            }

        }

        return false;

    }

    public void banPlayer(Player p, String reason){

        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();
        String path = "bans." + uuid + ".";

        cfg.get().getConfigurationSection("bans").createSection(uuid);
        cfg.get().set(path + "name", p.getName());
        cfg.get().set(path + "uuid", uuid);
        cfg.get().set(path + "reason", reason);

        cfg.save();

    }

    public void banOfflinePlayer(OfflinePlayer p, String reason){

        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();
        String path = "bans." + uuid + ".";

        cfg.get().getConfigurationSection("bans").createSection(uuid);
        cfg.get().set(path + "name", p.getName());
        cfg.get().set(path + "uuid", uuid);
        cfg.get().set(path + "reason", reason);

        cfg.save();

    }

    public void unbanPlayer(Player p){

        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();

        cfg.get().set("bans." + uuid, null);
        cfg.save();

    }

    public void unbanOfflinePlayer(OfflinePlayer p){

        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();

        cfg.get().set("bans." + uuid, null);
        cfg.save();

    }

    public void mutePlayer(Player p, String reason){

        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();
        String path = "mutes." + uuid + ".";

        cfg.get().getConfigurationSection("mutes").createSection(uuid);
        cfg.get().set(path + "name", p.getName());
        cfg.get().set(path + "uuid", uuid);
        cfg.get().set(path + "reason", reason);

        cfg.save();

    }

    public void muteOfflinePlayer(OfflinePlayer p, String reason){

        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();
        String path = "mutes." + uuid + ".";

        cfg.get().getConfigurationSection("mutes").createSection(uuid);
        cfg.get().set(path + "name", p.getName());
        cfg.get().set(path + "uuid", uuid);
        cfg.get().set(path + "reason", reason);

        cfg.save();

    }

    public void unmutePlayer(Player p){

        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();

        cfg.get().set("mutes." + uuid, null);
        cfg.save();

    }

    public void unmuteOfflinePlayer(OfflinePlayer p){

        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();

        cfg.get().set("mutes." + uuid, null);
        cfg.save();

    }

    public void tempBanPlayer(Player p, int sec, String reason){

        long t = sec * 1000L;
        long time = System.currentTimeMillis() + t;
        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();
        String path = "tempbans." + uuid + ".";

        cfg.get().getConfigurationSection("tempbans").createSection(uuid);
        cfg.get().set(path + "name", p.getName());
        cfg.get().set(path + "uuid", uuid);
        cfg.get().set(path + "reason", reason);
        cfg.get().set(path + "date", time);

        cfg.save();

    }

    public void tempBanPlayer(OfflinePlayer p, int sec, String reason){

        long t = sec * 1000L;
        long time = System.currentTimeMillis() + t;
        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();
        String path = "tempbans." + uuid + ".";

        cfg.get().getConfigurationSection("tempbans").createSection(uuid);
        cfg.get().set(path + "name", p.getName());
        cfg.get().set(path + "uuid", uuid);
        cfg.get().set(path + "reason", reason);
        cfg.get().set(path + "date", time);

        cfg.save();

    }

    public void tempMutePlayer(Player p, int sec, String reason){

        long t = sec * 1000L;
        long time = System.currentTimeMillis() + t;
        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();
        String path = "tempmutes." + uuid + ".";

        cfg.get().getConfigurationSection("tempmutes").createSection(uuid);
        cfg.get().set(path + "name", p.getName());
        cfg.get().set(path + "uuid", uuid);
        cfg.get().set(path + "reason", reason);
        cfg.get().set(path + "date", time);

        cfg.save();

    }

    public void tempMutePlayer(OfflinePlayer p, int sec, String reason){

        long t = sec * 1000L;
        long time = System.currentTimeMillis() + t;
        String uuid = p.getUniqueId().toString();
        FileManager.Config cfg = getData();
        String path = "tempmutes." + uuid + ".";

        cfg.get().getConfigurationSection("tempmutes").createSection(uuid);
        cfg.get().set(path + "name", p.getName());
        cfg.get().set(path + "uuid", uuid);
        cfg.get().set(path + "reason", reason);
        cfg.get().set(path + "date", time);

        cfg.save();

    }

    public void kickPlayer(Player p, String reason){

        cfg = new ConfigYML(plugin);
        String s = Msg.translate(reason);
        p.kickPlayer(cfg.prefix() + s);

    }

    public void kickPlayer(Player p){

        cfg = new ConfigYML(plugin);
        String s = cfg.prefix() + cfg.getDefaultKick();

        p.kickPlayer(s);

    }

    public List<String> getIPs(Player p){

        UUID uuid = p.getUniqueId();
        return getData().get().getStringList("ips." + uuid.toString());

    }

    public List<String> getIPs(OfflinePlayer p){

        UUID uuid = p.getUniqueId();
        return getData().get().getStringList("ips." + uuid.toString());

    }

    public void ipbanPlayer(Player p){

        List<String> ips = getIPs(p);
        List<String> current = getData().get().getStringList("ipbans");

        for(String s : ips){

            if(!current.contains(s)) {

                current.add(s);

            }

        }

        getData().get().set("ipbans", current);
        getData().save();

    }

    public void ipbanPlayer(OfflinePlayer p){

        List<String> ips = getIPs(p);
        List<String> current = getData().get().getStringList("ipbans");

        for(String s : ips){

            if(!current.contains(s)) {

                current.add(s);

            }

        }

        getData().get().set("ipbans", current);
        getData().save();

    }

    public void unIPBanPlayer(Player p){

        List<String> ips = getIPs(p);
        List<String> current = getData().get().getStringList("ipbans");

        for(String s : ips){

            if(!current.contains(s)) {

                current.remove(s);

            }

        }

        getData().get().set("ipbans", current);
        getData().save();

    }

    public void unIPBanPlayer(OfflinePlayer p){

        List<String> ips = getIPs(p);
        List<String> current = getData().get().getStringList("ipbans");

        for(String s : ips){

            if(!current.contains(s)) {

                current.remove(s);

            }

        }

        getData().get().set("ipbans", current);
        getData().save();

    }

}
