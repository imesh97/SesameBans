package xyz.imdafatboss.sesamebans.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class StaffMode {

    public static List<Player> vanished = new ArrayList<Player>();
    public static List<Player> fly = new ArrayList<Player>();
    public static List<Player> freeze = new ArrayList<Player>();
    public static List<Player> staffmode = new ArrayList<Player>();

    public static Map<Player, Inventory> inventory = new HashMap<Player, Inventory>();
    public static Map<Player, ItemStack[]> armor = new HashMap<Player, ItemStack[]>();

    // ItemStacks
    public static ItemStack getFlyFeather(){

        ItemStack is = new ItemStack(Material.FEATHER);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(Msg.translate("&f&lFLY FEATHER"));
        String[] lore = {Msg.translate("&7Fly around like a bird."), Msg.translate("&fJust with a right click.")};
        im.setLore(Arrays.asList(lore));

        is.setItemMeta(im);
        return is;

    }

    public static ItemStack getInvseeBook(){

        ItemStack is = new ItemStack(Material.BOOK);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(Msg.translate("&a&lINV-PATROL"));
        String[] lore = {Msg.translate("&2Patrol the inventory of a player."), Msg.translate("&aJust with a right click.")};
        im.setLore(Arrays.asList(lore));

        is.setItemMeta(im);
        return is;

    }

    public static ItemStack getFreezeBlock(){

        ItemStack is = new ItemStack(Material.PACKED_ICE);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(Msg.translate("&b&lFREEZE BLOCK"));
        String[] lore = {Msg.translate("&3Freeze a player."), Msg.translate("&bJust with a right click.")};
        im.setLore(Arrays.asList(lore));

        is.setItemMeta(im);
        return is;

    }

    public static ItemStack getThroughCompass(){

        ItemStack is = new ItemStack(Material.COMPASS);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(Msg.translate("&c&lTHROUGH COMPASS"));
        String[] lore = {Msg.translate("&4Go through things, and navigate faster."), Msg.translate("&cJust with a right click.")};
        im.setLore(Arrays.asList(lore));

        is.setItemMeta(im);
        return is;

    }

    public static ItemStack getVanisher(){

        ItemStack is = new ItemStack(Material.GHAST_TEAR);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(Msg.translate("&7&lVANISHER"));
        String[] lore = {Msg.translate("&8Vanish. Exactly."), Msg.translate("&7Just with a right click.")};
        im.setLore(Arrays.asList(lore));

        is.setItemMeta(im);
        return is;

    }

    public static ItemStack getRandomTP(){

        ItemStack is = new ItemStack(Material.ENDER_PEARL);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(Msg.translate("&6&lRANDOM TP"));
        String[] lore = {Msg.translate("&eTeleport to a random player."), Msg.translate("&6Just with a right click.")};
        im.setLore(Arrays.asList(lore));

        is.setItemMeta(im);
        return is;

    }

    public static boolean isStaffStack(ItemStack is){

        if(is != null || is.getType() != Material.AIR){

            for(String s : is.getItemMeta().getLore()){

                if(s.contains("Just with a right click.")){

                    return true;

                }

            }

            return false;

        }

        return false;

    }

    public static boolean isFlyStack(ItemStack is){

        if(is != null || is.getType() != Material.AIR){

            if(isStaffStack(is)){

                if(is.getItemMeta().getDisplayName().equals(getFlyFeather().getItemMeta().getDisplayName())){

                    for(String s : is.getItemMeta().getLore()){

                        for(String s1 : getFlyFeather().getItemMeta().getLore()){

                            if(s.equals(s1)){

                                return true;

                            }

                        }

                    }

                    return false;

                }

                return false;

            }

            return false;

        }

        return false;

    }

    public static boolean isInvStack(ItemStack is){

        if(is != null || is.getType() != Material.AIR){

            if(isStaffStack(is)){

                if(is.getItemMeta().getDisplayName().equals(getInvseeBook().getItemMeta().getDisplayName())){

                    for(String s : is.getItemMeta().getLore()){

                        for(String s1 : getInvseeBook().getItemMeta().getLore()){

                            if(s.equals(s1)){

                                return true;

                            }

                        }

                    }

                    return false;

                }

                return false;

            }

            return false;

        }

        return false;

    }

    public static boolean isFreezeStack(ItemStack is){

        if(is != null || is.getType() != Material.AIR){

            if(isStaffStack(is)){

                if(is.getItemMeta().getDisplayName().equals(getFreezeBlock().getItemMeta().getDisplayName())){

                    for(String s : is.getItemMeta().getLore()){

                        for(String s1 : getFreezeBlock().getItemMeta().getLore()){

                            if(s.equals(s1)){

                                return true;

                            }

                        }

                    }

                    return false;

                }

                return false;

            }

            return false;

        }

        return false;

    }

    public static boolean isThroughStack(ItemStack is){

        if(is != null || is.getType() != Material.AIR){

            if(isStaffStack(is)){

                if(is.getItemMeta().getDisplayName().equals(getThroughCompass().getItemMeta().getDisplayName())){

                    for(String s : is.getItemMeta().getLore()){

                        for(String s1 : getThroughCompass().getItemMeta().getLore()){

                            if(s.equals(s1)){

                                return true;

                            }

                        }

                    }

                    return false;

                }

                return false;

            }

            return false;

        }

        return false;

    }

    public static boolean isVanishStack(ItemStack is){

        if(is != null || is.getType() != Material.AIR){

            if(isStaffStack(is)){

                if(is.getItemMeta().getDisplayName().equals(getVanisher().getItemMeta().getDisplayName())){

                    for(String s : is.getItemMeta().getLore()){

                        for(String s1 : getVanisher().getItemMeta().getLore()){

                            if(s.equals(s1)){

                                return true;

                            }

                        }

                    }

                    return false;

                }

                return false;

            }

            return false;

        }

        return false;

    }

    public static boolean isRandomStack(ItemStack is){

        if(is != null || is.getType() != Material.AIR){

            if(isStaffStack(is)){

                if(is.getItemMeta().getDisplayName().equals(getRandomTP().getItemMeta().getDisplayName())){

                    for(String s : is.getItemMeta().getLore()){

                        for(String s1 : getRandomTP().getItemMeta().getLore()){

                            if(s.equals(s1)){

                                return true;

                            }

                        }

                    }

                    return false;

                }

                return false;

            }

            return false;

        }

        return false;

    }

    public static void thru(Player p){

        Location loc = p.getLocation();
        int radius = 5;
        for (int x = -(radius); x <= radius; x ++)
        {
            for (int y = -(radius); y <= radius; y ++)
            {
                for (int z = -(radius); z <= radius; z ++)
                {

                    Location l = new Location(p.getWorld(), x, y, z);
                    if(l.getBlock().getType() != null || l.getBlock().getType() != Material.AIR && (x != 0 || y != 0 || z != 0)){

                        int range = 3;
                        for(int x1 = -(range); x1 <= range; x1++){

                            for (int y1 = -(range); y1 <= range; y1 ++)
                            {

                                for (int z1 = -(range); z1 <= range; z1 ++)
                                {

                                    Location l1 = new Location(p.getWorld(), x1, y1, z1);
                                    if(l1.getBlock().getType() == null || l1.getBlock().getType() == Material.AIR){

                                        p.teleport(l1);

                                    }

                                }

                            }

                        }

                    }

                }
            }
        }

    }

}
