package org.se0k.dirtspawn;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Util {
    @SuppressWarnings("StringRepeatCanBeUsed")
    public static @NotNull String centerTitle(String title) {
        StringBuilder spacer = new StringBuilder();
        int spaces = 20 - ChatColor.stripColor(title).length();
        for (int i = 0; i < spaces; i++) {
            spacer.append(" ");
        }
        return spacer + title;
    } // 여기서 GUI 이름 중간으로 받아옴
    private static HashMap<String, World> worldMap = null;
    public static World getWorld(String worldName) {
        if (worldMap == null) {
            worldMap = new HashMap<>() {{ Bukkit.getWorlds().forEach(world -> put(world.getName(), world)); }};
        }

        World world = worldMap.get(worldName);
        if (world == null) {
            world = Bukkit.getWorld(worldName);
            worldMap.put(worldName, world);
        }
        return world;
    }
}
