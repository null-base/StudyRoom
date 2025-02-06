package com.nullbase.tutorialpluguin

import org.bukkit.inventory.Inventory
import org.bukkit.plugin.java.JavaPlugin
import java.util.UUID

class TutorialPluguin : JavaPlugin() {

    companion object {
        val guiMap: MutableMap<UUID, Inventory> = mutableMapOf()
    }

    override fun onEnable() {
        // Plugin startup logic
        server.pluginManager.registerEvents(EventListener, this)
        getCommand("debug")?.setExecutor(DebugCommand)
        getCommand("sum")?.setExecutor(SumCommand)
        getCommand("gui")?.setExecutor(GuiCommand)

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
