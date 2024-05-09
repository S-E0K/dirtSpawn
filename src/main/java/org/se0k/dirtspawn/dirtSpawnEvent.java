package org.se0k.dirtspawn;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class dirtSpawnEvent implements Listener {


    //
    @EventHandler
    public static void setDirt(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        Location dirtRandom = new Location(world, -32, -55, -529);
        Location grassReset = new Location(world, -30, -55, -529);
        Location startLoc = new Location(world, -32, -56, -528);
        if (e.getClickedBlock() == null) return;
        if (e.getClickedBlock().getType() != Material.STONE_BUTTON) return;

        if (e.getClickedBlock().getLocation().equals(dirtRandom)) dirtRandom(startLoc);
        if (e.getClickedBlock().getLocation().equals(grassReset)) grassRandom(startLoc);

    }

    public static void dirtRandom(Location startLoc) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (startLoc.getBlock().getType() != Material.DIRT_PATH) return;
                double check = Math.floor(Math.random() * 100);
                if (check >= 50) startLoc.getBlock().setType(Material.GRASS_BLOCK);

                startLoc.setX(startLoc.getX() + j);
            }
            startLoc.setY(startLoc.getY() + i);
        }
    }

    public static void grassRandom(Location startLoc) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (startLoc.getBlock().getType() != Material.DIRT_PATH) return;
                startLoc.getBlock().setType(Material.GRASS_BLOCK);

                startLoc.setX(startLoc.getX() + j);
            }
            startLoc.setY(startLoc.getY() + i);
        }
    }

}
