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
        if (e.getClickedBlock().getLocation().equals(grassReset)) allDirt(startLoc);

    }

    public static void dirtRandom(Location startLoc) {
        double thisX = startLoc.getX();
        double thisZ = startLoc.getZ();
        for (int i = 1; i <= 16; i++) {
            for (int j = 1; j <= 16; j++) {
                double check = Math.floor(Math.random() * 100);
                if (startLoc.getBlock().getType() == Material.DIRT_PATH) {
                    if (check <= 50) startLoc.getBlock().setType(Material.GRASS_BLOCK);
                }
                startLoc.setX(thisX + j);
            }
            startLoc.setX(thisX);
            startLoc.setZ(thisZ + i);
        }
    }

    public static void allDirt(Location startLoc) {
        double thisX = startLoc.getX();
        double thisZ = startLoc.getZ();
        for (int i = 1; i <= 16; i++) {
            for (int j = 1; j <= 16; j++) {
                startLoc.getBlock().setType(Material.DIRT_PATH);

                startLoc.setX(thisX + j);
            }
            startLoc.setX(thisX);
            startLoc.setZ(thisZ + i);
        }
    }

}
