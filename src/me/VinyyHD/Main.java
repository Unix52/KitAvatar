package me.VinyyHD;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Main
  extends JavaPlugin
  implements Listener
  
  {
	  public static Plugin plugin;
	public static List<String> Lapis2 = new ArrayList<String>();
	public static List<String> Ferro2 = new ArrayList<String>();
	public static List<String> Red2 = new ArrayList<String>();
	public static List<String> Terra2 = new ArrayList<String>();
	public static List<Player> Tempo = new ArrayList<Player>();

	public boolean BossBarON = false;
	
	  public void onEnable()
	  {
		  plugin = this;
		getServer().getConsoleSender().sendMessage("§b§lAvatar §aBy: §4VinyyHD §b& §cAdrian §b& §6RemiixRandona");
	    Bukkit.getServer().getPluginManager().registerEvents(new Avatar(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Terra(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Ferro(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Red(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Lapis(this), this);
	    if (Bukkit.getPluginManager().getPlugin("BarAPI") != null)
	    {
	      this.BossBarON = true;
	    }
	    if (Bukkit.getPluginManager().getPlugin("BarAPI") == null)
	    {
	    	getLogger().log(Level.INFO, "Seu servidor nao esta com BarAPI para ter o BossBar do kit!");
	    }

	  }
  
public void onDisable() {}



@EventHandler
public void BossBarON(EntityDamageByEntityEvent e)
{
	if (this.BossBarON) {
  if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
  {
    Entity ent = e.getEntity();
    Player damager = (Player)e.getDamager();
    Player p = (Player)ent;
    if ((damager.getItemInHand() != null) && (damager.getItemInHand().getType() != null)) {
      BarAPI.setMessage(damager, p.getName() + " - Avatar", 2);
    
    }
  }
 }
}

}