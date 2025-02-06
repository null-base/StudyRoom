package com.nullbase.tutorialpluguin

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object GuiCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            return false
        }
        val inventory = Bukkit.createInventory(sender, 9 * 3, "§bメニュー")

        val diamond = ItemStack(Material.DIAMOND, 1)
        val diamondMeta = diamond.itemMeta
        diamondMeta?.setDisplayName("§b青輝石")
        diamond.itemMeta = diamondMeta
        inventory.setItem(12, diamond)

        val emerald = ItemStack(Material.EMERALD, 1)
        val emeraldMeta = emerald.itemMeta
        emeraldMeta?.setDisplayName("§緑輝石")
        emerald.itemMeta = emeraldMeta
        inventory.setItem(14, emerald)

        TutorialPluguin.guiMap[sender.uniqueId] = inventory
        sender.openInventory(inventory)
        return true
    }
}