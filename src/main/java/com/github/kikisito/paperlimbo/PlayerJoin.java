package com.github.kikisito.paperlimbo;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoin implements Listener {
    private final Main plugin;

    public PlayerJoin(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Location loc = new Location(plugin.getServer().getWorld("world"), 0, 64, 0, 0, 0);
        Player p = e.getPlayer();
        // Hide players
        plugin.getServer().getOnlinePlayers().forEach(player -> player.hidePlayer(plugin, p));
        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0, false, false, false));
        // Set spectator
        p.setGameMode(GameMode.SPECTATOR);
        // Teleport to box
        p.setAllowFlight(true);
        p.teleportAsync(loc);
        // Send message
        p.spigot().sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&6Te encuentras en el limbo debido a una interrupción en tu conexión con el servidor principal. Si no eres transportado nuevamente en unos minutos, contacta con el staff.")));
    }
}
