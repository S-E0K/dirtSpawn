package org.se0k.dirtspawn;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class DirtSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new dirtSpawnEvent(), this);

        Objects.requireNonNull(getCommand("fl")).setExecutor((sender, command, label, args) -> {
            if (sender.isOp()) {
                Bukkit.dispatchCommand(sender, "reload confirm");
            }
            return true;
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
