package com.github.kikisito.limbo;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public final class LimboWaterfall extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().getPluginManager().registerCommand(this, new EdorasCommand(this));
    }
}

final class EdorasCommand extends Command {
    private final LimboWaterfall plugin;
    public EdorasCommand(LimboWaterfall plugin) {
        super("edoras");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer)) return;
        ProxiedPlayer p = (ProxiedPlayer) sender;
        p.connect(plugin.getProxy().getServerInfo("survival"));
    }
}