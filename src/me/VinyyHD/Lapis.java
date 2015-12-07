package me.VinyyHD;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public class Lapis
implements Listener
{
public Plugin plugin;

public Lapis(Main plugin)
{
  this.plugin = plugin;
}

ArrayList<Snowball> Soltou = new ArrayList<Snowball>();
public int id1;

@EventHandler
public void AvatarAr(PlayerInteractEvent event)
{
  final Player p = event.getPlayer();

  if (Main.Lapis2.contains(p.getName()) && (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
		  (p.getItemInHand().getType() == Material.LAPIS_BLOCK))) {
	  
	  event.setCancelled(true);
	  
	  if (!Main.Tempo.contains(p)) {
	Main.Tempo.add(p);
	
    Vector Agua = p.getLocation().getDirection().normalize().multiply(55);
    Snowball AguaH = (Snowball)p.launchProjectile(Snowball.class);
    AguaH.setVelocity(Agua);
    AguaH.setMetadata("Agua", new FixedMetadataValue(Main.plugin, Boolean.valueOf(true)));

    Location pegou = p.getEyeLocation();

    BlockIterator Aguao = new BlockIterator(pegou, 0.0D, 40);

    while (Aguao.hasNext())
    {
      Location Aguao2 = Aguao.next().getLocation();

      Effect camelo = Effect.STEP_SOUND;
      p.playSound(p.getLocation(), Sound.STEP_WOOD, 5.5F, 5.5F);
      p.playSound(p.getLocation(), Sound.STEP_WOOD, 1.5F, 1.5F);
      p.playSound(p.getLocation(), Sound.STEP_WOOD, 2.5F, 2.5F);
      p.playSound(p.getLocation(), Sound.STEP_WOOD, 3.5F, 3.5F);
      p.playSound(p.getLocation(), Sound.STEP_WOOD, 4.5F, 4.5F);
      
      p.getWorld().playEffect(Aguao2, camelo, 9);
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
    	if (Tomou.hasMetadata("Agua")) {
        event.setDamage(11.0);
        ((LivingEntity) Tomou2).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 0), true);
        
        Vector vector = Tomou2.getLocation().getDirection();
        vector.multiply(-1.0F);
        Tomou2.setVelocity(vector);
        
        
        
    }
}
}
}