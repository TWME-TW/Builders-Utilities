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
package net.arcaniax.buildersutilities.commands;

import net.arcaniax.buildersutilities.BuildersUtilities;
import net.arcaniax.buildersutilities.Settings;
import net.arcaniax.buildersutilities.commands.system.ICommand;
import net.arcaniax.buildersutilities.listeners.PlayerMoveListener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AdvancedFlyCommand implements ICommand {

    @Override
    public void execute(Player player, String[] args) {
        if (!player.hasPermission("builders.util.advancedfly")) {
            if (Settings.sendErrorMessages) {
                player.sendMessage(BuildersUtilities.MSG_NO_PERMISSION + "builders.util.advancedfly");
            }
            return;
        }

        if (PlayerMoveListener.togglePlayer(player)) {
            player.sendMessage(BuildersUtilities.MSG_PREFIX + "高級飛行 " + ChatColor.GREEN + "啟用");
        } else {
            player.sendMessage(BuildersUtilities.MSG_PREFIX + "高級飛行 " + ChatColor.RED + "停用");
        }
    }

}
