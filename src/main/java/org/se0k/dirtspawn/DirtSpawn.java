package org.se0k.dirtspawn;

import org.bukkit.plugin.java.JavaPlugin;

public final class DirtSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new dirtSpawnEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
