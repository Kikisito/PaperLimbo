package com.github.kikisito.limbo.listeners;

import com.github.kikisito.limbo.LimboPlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerJoin implements Listener {
    private LimboPlugin plugin;

    public PlayerJoin(LimboPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent e){
        Location loc = new Location(plugin.getServer().getWorld("limbo"), 0, 0, 0, 45, 0);
        Player p = e.getPlayer();
        p.setGameMode(GameMode.SPECTATOR);
        p.teleportAsync(loc);
        p.spigot().sendMessage(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&6Te encuentras en el limbo de Edoras.\n&eHas sido transportado a esta dimensión debido a que se ha perdido la conexión con el servidor survival. Esto suele ocurrir en reinicios.\nPara volver a Edoras, simplemente espera o escribe &a/edoras")));
    }
}
