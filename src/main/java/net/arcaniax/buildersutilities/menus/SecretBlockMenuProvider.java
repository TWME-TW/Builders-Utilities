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
package net.arcaniax.buildersutilities.menus;

import net.arcaniax.buildersutilities.menus.inv.ClickableItem;
import net.arcaniax.buildersutilities.menus.inv.content.InventoryContents;
import net.arcaniax.buildersutilities.menus.inv.content.InventoryProvider;
import net.arcaniax.buildersutilities.utils.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SecretBlockMenuProvider implements InventoryProvider {

    private static final ItemStack SPAWNER = Items.create(Material.SPAWNER, ChatColor.BLUE + "生怪磚", "");
    private static final ItemStack BARRIER = Items.create(Material.BARRIER, ChatColor.RED + "屏障", "");
    private static final ItemStack DRAGON_EGG = Items.create(
            Material.DRAGON_EGG,
            ChatColor.LIGHT_PURPLE + "龍蛋",
            ""
    );
    private static final ItemStack STRUCTURE_VOID = Items.create(
            Material.STRUCTURE_VOID,
            ChatColor.DARK_AQUA + "結構空位",
            ""
    );
    private static final ItemStack DEBUG_STICK = Items.create(
            Material.DEBUG_STICK,
            ChatColor.AQUA + "除錯棒",
            "&7只有在創造模式下才有效"
    );
    private static final ItemStack STRUCTURE_BLOCK = Items.create(
            Material.STRUCTURE_BLOCK,
            ChatColor.AQUA + "結構方塊",
            ""
    );
    private static final ItemStack LIGHT = Items.create(
            "光源方塊",
            ChatColor.GOLD + "光源方塊",
            ""
    );

    @Override
    public void init(Player player, InventoryContents contents) {
        contents.set(0, 0, ClickableItem.of(DEBUG_STICK, inventoryClickEvent -> player.getInventory().addItem(DEBUG_STICK)));
        contents.set(0, 1, ClickableItem.of(SPAWNER, inventoryClickEvent -> player.getInventory().addItem(SPAWNER)));
        contents.set(0, 2, ClickableItem.of(BARRIER, inventoryClickEvent -> player.getInventory().addItem(BARRIER)));
        contents.set(
                0,
                3,
                ClickableItem.of(STRUCTURE_VOID, inventoryClickEvent -> player.getInventory().addItem(STRUCTURE_VOID))
        );
        contents.set(0, 4, ClickableItem.of(DRAGON_EGG, inventoryClickEvent -> player.getInventory().addItem(DRAGON_EGG)));
        contents.set(
                0,
                5,
                ClickableItem.of(STRUCTURE_BLOCK, inventoryClickEvent -> player.getInventory().addItem(STRUCTURE_BLOCK))
        );
        if (LIGHT != null) {
            contents.set(0, 6, ClickableItem.of(LIGHT, inventoryClickEvent -> player.getInventory().addItem(LIGHT)));
        }
    }


}
