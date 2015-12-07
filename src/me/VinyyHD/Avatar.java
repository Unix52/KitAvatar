package me.VinyyHD;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Avatar
  implements Listener
{
public Plugin plugin;
  
  public Avatar(Main plugin)
  {
    this.plugin = plugin;
  }

 
  @EventHandler
  public void Trocar(PlayerInteractEvent e)
  {
   Player p = e.getPlayer();
   String b = ChatColor.BOLD + "";
    
   ItemStack Terra = new ItemStack(Material.GRASS);
   ItemMeta terram = Terra.getItemMeta();
   terram.setDisplayName(ChatColor.DARK_GREEN + b + "Terra");
   Terra.setItemMeta(terram);
   
   ItemStack Agua = new ItemStack(Material.LAPIS_BLOCK);
   ItemMeta Aguam = Agua.getItemMeta();
   Aguam.setDisplayName(ChatColor.DARK_AQUA + b + "Agua");
   Agua.setItemMeta(Aguam);
   
   ItemStack Aguac = new ItemStack(Material.BEACON);
   ItemMeta Aguacm = Aguac.getItemMeta();
   Aguacm.setDisplayName(ChatColor.DARK_AQUA + b + "B");
   Aguac.setItemMeta(Aguacm);
   
   ItemStack AR = new ItemStack(Material.WOOL);
   ItemMeta ARm = AR.getItemMeta();
   ARm.setDisplayName(b + "AR");
   AR.setItemMeta(ARm);
   
   
   ItemStack Fogo = new ItemStack(Material.REDSTONE_BLOCK);
   ItemMeta Fogom = Fogo.getItemMeta();
   Fogom.setDisplayName(ChatColor.RED + b + "Fogo");
   Fogo.setItemMeta(Fogom);
   
   if  (((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && 
           (p.getItemInHand().getType() == (Material.BEACON)))	
	   
  {
   p.setItemInHand(AR);
   Main.Ferro2.add(p.getName());
  }
   else if (Main.Ferro2.contains(p.getName()) && (((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && 
            (p.getItemInHand().equals(AR))))	   
   {
    p.setItemInHand(Agua);
    Main.Ferro2.remove(p.getName());
    Main.Lapis2.add(p.getName());
   }
   else if (Main.Lapis2.contains(p.getName()) && (((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && 
           (p.getItemInHand().equals(Agua))))
  {
   p.setItemInHand(Terra);
   Main.Lapis2.remove(p.getName());
   Main.Terra2.add(p.getName());
  }
   else if (Main.Terra2.contains(p.getName()) && (Main.Terra2.contains(p.getName()) && (((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && 
            (p.getItemInHand().equals(Terra)))))
   {
    p.setItemInHand(Fogo);
    Main.Terra2.remove(p.getName());
    Main.Red2.add(p.getName());
   }
   else if (Main.Red2.contains(p.getName()) && (((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && 
            (p.getItemInHand().equals(Fogo))))
   {
    p.setItemInHand(AR);
    Main.Red2.remove(p.getName());
    Main.Ferro2.add(p.getName());
    
   }
   }
}
  
		
		
	
	
