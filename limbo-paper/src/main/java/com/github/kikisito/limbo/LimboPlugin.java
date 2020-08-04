package com.github.kikisito.limbo;

import com.github.kikisito.limbo.listeners.MoveEvent;
import com.github.kikisito.limbo.listeners.PlayerJoin;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class LimboPlugin extends JavaPlugin {
    BukkitTask task;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        this.getServer().getPluginManager().registerEvents(new MoveEvent(this), this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        task = this.getServer().getScheduler().runTaskTimerAsynchronously(this, () -> {
            for(Player p : this.getServer().getOnlinePlayers()){
                if(p.hasPermission("edoras.limbo.bypass")) continue;
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");
                out.writeUTF("survival");
                p.sendPluginMessage(this, "BungeeCord", out.toByteArray());
            }
        }, 0, 900);
    }

    @Override
    public void onDisable() {
        task.cancel();
    }
}
