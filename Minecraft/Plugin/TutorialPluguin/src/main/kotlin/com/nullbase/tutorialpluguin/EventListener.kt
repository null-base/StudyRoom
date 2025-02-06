package com.nullbase.tutorialpluguin

import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerJoinEvent

object EventListener : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.joinMessage = "§e{event.player.name}がサーバーに参加しました｡"
    }

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        if (TutorialPluguin.guiMap[event.whoClicked.uniqueId] == event.inventory) {
            event.isCancelled = true

            if (event.currentItem == null) {
                return
            }

            val player = Bukkit.getPlayer(event.whoClicked.name)

            if (event.currentItem!!.type == Material.DIAMOND) {
                player?.performCommand("tp @s ~ ~10 ~")
            }

            if (event.currentItem!!.type == Material.EMERALD) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give ${player?.name} diamond")
            }
        }
    }
}