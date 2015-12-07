package me.VinyyHD;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public class Red
implements Listener
{
public Plugin plugin;

public Red(Main plugin)
{
  this.plugin = plugin;
}

ArrayList<Snowball> Soltou = new ArrayList<Snowball>();
public int id1;

@EventHandler
public void AvatarAr(PlayerInteractEvent event)
{
  final Player p = event.getPlayer();

  if (Main.Red2.contains(p.getName()) && (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
		  (p.getItemInHand().getType() == Material.REDSTONE_BLOCK))) {
	  
	  event.setCancelled(true);
	  
	  if (!Main.Tempo.contains(p)) {
	Main.Tempo.add(p);
	
    Vector Fogo = p.getLocation().getDirection().normalize().multiply(55);
    Snowball FogoH = (Snowball)p.launchProjectile(Snowball.class);
    FogoH.setVelocity(Fogo);
    FogoH.setMetadata("Fogo", new FixedMetadataValue(Main.plugin, Boolean.valueOf(true)));

    Location pegou = p.getEyeLocation();

    BlockIterator Fogao = new BlockIterator(pegou, 0.0D, 40);

    while (Fogao.hasNext())
    {
      Location Fogao2 = Fogao.next().getLocation();

      Effect camelo = Effect.STEP_SOUND;
      p.playSound(p.getLocation(), Sound.FIRE, 5.5F, 5.5F);
      p.playSound(p.getLocation(), Sound.FIRE, 1.5F, 1.5F);
      p.playSound(p.getLocation(), Sound.FIRE, 2.5F, 2.5F);
      p.playSound(p.getLocation(), Sound.FIRE, 3.5F, 3.5F);
      p.playSound(p.getLocation(), Sound.FIRE, 4.5F, 4.5F);
      
      p.getWorld().playEffect(Fogao2, camelo, 10);
    }
    this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
    {
    public void run()
      {
       if (Main.Tempo.contains(p))
      	 {
    	   Main.Tempo.remove(p);
    	   p.sendMessage("§6-> §c§o Você já pode usar seu Kit."); 
         p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);  
      }
      }
    }, 600L);
  }
	  else
	  {
		  p.sendMessage("§6-> §4§o Aguarde mais um pouco para usar seu kit !");
		  
	  }
	 
}
}


@EventHandler
public void EntityDamageEvent (EntityDamageByEntityEvent event){
	 Entity Tomou2 = event.getEntity();
    if(event.getDamager() instanceof Snowball) {   
    	Snowball Tomou = (Snowball)event.getDamager();
    	if (Tomou.hasMetadata("Fogo")) {
        event.setDamage(12.0);
        Tomou2.setFireTicks(150);
        
        
    }
}
}
}