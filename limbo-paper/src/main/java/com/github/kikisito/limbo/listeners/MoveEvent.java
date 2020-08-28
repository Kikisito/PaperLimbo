package com.github.kikisito.limbo.listeners;

import com.github.kikisito.limbo.LimboPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {
    private LimboPlugin plugin;

    public MoveEvent(LimboPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Location loc = new Location(plugin.getServer().getWorld("world"), 0, 64, 0, 0, 0);
        Player p = e.getPlayer();
        if(!p.getLocation().equals(loc)){
            p.teleportAsync(loc);
        }
        plugin.sendToSurvival(p);
        e.setCancelled(true);
    }
}
