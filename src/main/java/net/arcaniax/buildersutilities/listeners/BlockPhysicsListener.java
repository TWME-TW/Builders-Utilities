/*
 * Builder's Utilities is a collection of a lot of tiny features that help with building.
 * Copyright (C) Arcaniax-Development
 * Copyright (C) Arcaniax team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package net.arcaniax.buildersutilities.listeners;

import net.arcaniax.buildersutilities.Settings;
import net.arcaniax.buildersutilities.utils.LogManagerCompat;
import org.apache.logging.log4j.Logger;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class BlockPhysicsListener implements Listener {

    private static final Logger logger = LogManagerCompat.getLogger();

    @EventHandler
    public void onPhysics(BlockPhysicsEvent e) {
        if (e.getSourceBlock().getType().equals(Material.AIR)) {
            if (e.getChangedType().equals(Material.AIR)) {
                if (e.getBlock().getLocation().getBlockY() > 0) {
                    if (e
                            .getBlock()
                            .getLocation()
                            .add(0, -1, 0)
                            .getBlock()
                            .getType()
                            .name()
                            .toLowerCase()
                            .contains("grass_block")) {
                        return;
                    }
                }
            }
        }
        if (e.getSourceBlock().getType().name().toLowerCase().contains("snow")) {
            if (e.getBlock().getLocation().getBlockY() > 0) {
                if (e.getBlock().getLocation().add(0, -1, 0).getBlock().getType().name().toLowerCase().contains("grass_block")) {
                    return;
                }
            }
        }
        try {
            if (e.getChangedType().name().toLowerCase().contains("chest") ||
                    e.getChangedType().name().toLowerCase().contains("stair") ||
                    e.getChangedType().name().toLowerCase().contains("fence") ||
                    e.getChangedType().name().toLowerCase().contains("pane") ||
                    e.getChangedType().name().toLowerCase().contains("wall") ||
                    e.getChangedType().name().toLowerCase().contains("bar") ||
                    e.getChangedType().name().toLowerCase().contains("door")) {
                return;
            }
        } catch (Exception ex) {
            return;
        }
        if (!Settings.disableRedstone) {
            if (e.getChangedType().name().toLowerCase().contains("redstone") ||
                    e.getChangedType().name().toLowerCase().contains("daylight") ||
                    e.getChangedType().name().toLowerCase().contains("diode") ||
                    e.getChangedType().name().toLowerCase().contains("note") ||
                    e.getChangedType().name().toLowerCase().contains("lever") ||
                    e.getChangedType().name().toLowerCase().contains("button") ||
                    e.getChangedType().name().toLowerCase().contains("command") ||
                    e.getChangedType().name().toLowerCase().contains("tripwire") ||
                    e.getChangedType().name().toLowerCase().contains("plate") ||
                    e.getChangedType().name().toLowerCase().contains("string") ||
                    e.getChangedType().name().toLowerCase().contains("piston") ||
                    e.getChangedType().name().toLowerCase().contains("observer")) {
                if (!e.getBlock().getType().name().contains("air")) {
                    return;
                }
            }
        }

        if (e.getChangedType().hasGravity()) {
            if (Settings.disableGravityPhysics) {
                e.setCancelled(true);
                if (Settings.sendDebugMessages) {
                    logger.info(
                            "方塊重力(掉落)被取消是因為 disable-gravity-physics: true");
                }

            }
        } else {
            if (Settings.disablePhysics) {
                e.setCancelled(true);
                if (Settings.sendDebugMessages) {
                    logger.info(
                            "方塊物理被取消是因為 disable-physics: true");
                }
            }
        }

    }

}
