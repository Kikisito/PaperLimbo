package com.github.kikisito.limbo.listeners;

import com.github.kikisito.limbo.LimboPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {
    private LimboPlugin plugin;

    public MoveEvent(LimboPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerMoveEvent e){
        if(!e.getPlayer().hasPermission("edoras.limbo.bypass")){
            Player p = e.getPlayer();
            Location loc = new Location(plugin.getServer().getWorld("limbo"), 0, 0, 0);
            if(!p.getLocation().equals(loc)){
                p.teleportAsync(loc);
            }
            e.setCancelled(true);
        }
    }
}
