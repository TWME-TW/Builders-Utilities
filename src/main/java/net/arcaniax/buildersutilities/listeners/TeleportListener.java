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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportListener implements Listener {

    private static final Logger logger = LogManagerCompat.getLogger();

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (event.getCause().equals(PlayerTeleportEvent.TeleportCause.SPECTATE)) {
            if (!event.getPlayer().hasPermission("builders.util.tpgm3")) {
                event.setCancelled(true);
                if (Settings.sendDebugMessages) {
                    logger.info(
                            "觀察者傳送被取消，因為 {} 缺少權限 builders.util.tpgm3",
                            event.getPlayer()
                    );
                }
            }
        }
    }

}
