package xyz.imdafatboss.sesamebans.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.PlayerAPI;
import xyz.imdafatboss.sesamebans.config.ConfigYML;

public class TempbanEvents implements Listener{

    Home plugin;
    public TempbanEvents(Home instance){

        this.plugin = instance;

    }
    PlayerAPI papi;
    ConfigYML cfg;

    @EventHandler
    public void onPlayerIsTempbanned(PlayerLoginEvent e){

        papi = new PlayerAPI(plugin);
        cfg = new ConfigYML(plugin);
        Player p = e.getPlayer();
        if(papi.isTempbanned(p)){

            String banscreen = cfg.tempbanScreen(p);
            e.disallow(PlayerLoginEvent.Result.KICK_BANNED, banscreen);

        }

    }

}
