package xyz.imdafatboss.sesamebans.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.PlayerAPI;
import xyz.imdafatboss.sesamebans.config.ConfigYML;

import java.util.List;

public class IPBanEvents implements Listener{

    Home plugin;
    public IPBanEvents(Home instance){

        this.plugin = instance;

    }
    PlayerAPI papi;
    ConfigYML cfg;

    @EventHandler
    public void onPLayerIsIPBanned(PlayerLoginEvent e){

        papi = new PlayerAPI(plugin);
        cfg = new ConfigYML(plugin);
        Player p = e.getPlayer();
        String ip = p.getAddress().getAddress().toString().substring(1);
        if(papi.isIPBanned(ip)){

            String screen = cfg.getIPBanScreen();
            e.disallow(PlayerLoginEvent.Result.KICK_BANNED, screen);

        }

    }

    @EventHandler
    public void manageIPs(PlayerJoinEvent e){

        papi = new PlayerAPI(plugin);
        Player p = e.getPlayer();
        String ip = p.getAddress().getAddress().toString().substring(1);
        List<String> ips = papi.getIPs(p);

        if(!ips.contains(ip)){

            ips.add(ip);

        }

        papi.getData().get().set("ips." + p.getUniqueId().toString(), ips);
        papi.getData().save();

    }

}
